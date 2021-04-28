package parallelExecutor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.opencsv.exceptions.CsvException;

import searchEngineExecutor.UserAction;

public class FileReadingEngine {
	
	private static FileReadingEngine obj;
	
	private FileReadingEngine() {}
	
	public static synchronized FileReadingEngine getInstance() {
		
		if(obj == null)
			obj = new FileReadingEngine();
		
		return obj;
	}
	
	public List<List<Map<String, String>>> flightDetails = new ArrayList<>();
	
	public synchronized void addFlightDetails(List<Map<String, String>> airlineDetails) {
		
		flightDetails.add(airlineDetails);
	}

	private File[] fetchAllFiles() {
		
		String filePathDir = System.getProperty("user.dir") + "\\airlineDetails";
		
		File airlineDir = new File(filePathDir);
		
		File [] airlineFiles = airlineDir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.toLowerCase().endsWith(".csv");
			}
		});
		
		return airlineFiles;
	}
	
	public void showFlighDetails(UserAction user) throws IOException, CsvException, ParseException {
		
		searchDetailsInFlight();
		
		List<Map<String, String>> filteredFlights = new ArrayList<>();
		
		for(int i = 0; i < flightDetails.size(); i++) {
			
			filteredFlights.addAll(filterFiles(flightDetails.get(i), user));
		}
		
		if(filteredFlights.size() == 0) {
			
			System.out.println("Sorry, there are no flights available for the inputs provided.");
			return;
		}
		
		sortFlights(filteredFlights, user.outputPreference);
		
		
		  if(user.flightClass.equalsIgnoreCase("B"))
			  updateBusinessClassFare(filteredFlights);
		 
		
		for(Map<String, String> flight : filteredFlights) {
			
			System.out.println(flight);
		}
	}
	
	private void searchDetailsInFlight() throws IOException, CsvException {
		
		File[] allFiles = fetchAllFiles();
		
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		for(File file : allFiles) {
			
			Runnable extractContent = new FileContentExtractor(file);
			executor.execute(extractContent);
		}
		
		executor.shutdown();
        while (!executor.isTerminated()) {
        }
	}
	
	private List<Map<String, String>> filterFiles(List<Map<String, String>> airlineToFilter, UserAction user) throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); 
		
		for(int i = 0; i < airlineToFilter.size(); i++) {
			
			Date d1 = dateFormatter.parse(airlineToFilter.get(0).get("VALID_TILL"));
			Date d2 = dateFormatter.parse(user.flightDate);
			
			if(!airlineToFilter.get(i).get("DEP_LOC").equalsIgnoreCase(user.departureLocation)) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(!airlineToFilter.get(i).get("ARR_LOC").equalsIgnoreCase(user.arrivalLocation)) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(!airlineToFilter.get(i).get("CLASS").toUpperCase().contains(user.flightClass.toUpperCase())) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(airlineToFilter.get(i).get("SEAT_AVAILABILITY").equalsIgnoreCase("N")) {
				
				airlineToFilter.remove(i);
				i--;
			}
			
			else if(d1.compareTo(d2) < 0) {
				
				airlineToFilter.remove(i);
				i--;
			}
		}
		
		return airlineToFilter;
	}
	
	private void sortFlights(List<Map<String, String>> filteredFlights, String sortingPreference) {
		
		filteredFlights.sort(new Comparator<Map<String, String>>() {

			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				
				if(sortingPreference.equalsIgnoreCase("FD")) {
					
					if(o1.get("FARE").compareTo(o2.get("FARE")) == 0)
						return o1.get("FLIGHT_TIME").compareTo(o2.get("FLIGHT_TIME"));
				}
				
				return o1.get("FARE").compareTo(o2.get("FARE"));
			}
		});
	}
	
	private void updateBusinessClassFare(List<Map<String, String>> flights) {
		
		for(Map<String, String> flight : flights) {
			
			int fare = Integer.parseInt(flight.get("FARE"));
			
			fare = fare + (fare * 40) / 100; 
			
			flight.put("FARE", String.valueOf(fare));
		}
	}
}
