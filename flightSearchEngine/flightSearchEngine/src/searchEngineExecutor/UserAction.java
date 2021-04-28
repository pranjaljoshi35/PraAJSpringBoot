package searchEngineExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserAction {

	public String departureLocation;
	public String arrivalLocation;
	public String flightDate;
	public String flightClass;
	public String outputPreference;

	BufferedReader br;

	public void takeUserInput() throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter departure location: ");
		departureLocation = br.readLine();
		departureLocation = checkForCorrectLocationInput(departureLocation);

		System.out.print("Enter arrival location: ");
		arrivalLocation = br.readLine();
		arrivalLocation = checkForCorrectLocationInput(arrivalLocation);

		System.out.print("Enter flight departure date(DD-MM-YYYY): ");
		flightDate = br.readLine();
		flightDate = verifyDate(flightDate);

		System.out.println("Enter the flight class(B for Business class/E for Economy class): ");
		flightClass = br.readLine();
		flightClass = checkForFlightClass(flightClass);

		System.out.println("Enter the output preference(F for Sort on fare/FD for Sort on fare and flight duration)");
		outputPreference = br.readLine();
		outputPreference = checkForOutpuPreference(outputPreference);
	}

	private String checkForCorrectLocationInput(String location) throws IOException {

		while (location.length() != 3) {

			System.out.print("Sorry, you have entered incorrect location. Please try again: ");
			location = br.readLine();
		}

		return location;
	}

	private String checkForOutpuPreference(String preference) throws IOException {

		while (!(preference.equalsIgnoreCase("F") || preference.equalsIgnoreCase("FD"))) {

			System.out.print("Sorry, you have entered incorrect preference. Please try again: ");
			preference = br.readLine();
		}

		return preference;
	}
	
	private String checkForFlightClass(String flightClass) throws IOException {

		while (!(flightClass.equalsIgnoreCase("B") || flightClass.equalsIgnoreCase("E"))) {

			System.out.print("Sorry, you have entered incorrect class. Please try again: ");
			flightClass = br.readLine();
		}

		return flightClass;
	}
	
	private String verifyDate(String date) throws IOException {
		
		while(!checkForDateFormat(date)) {
			
			System.out.print("Sorry, you have entered incorrect date format. Please try again: ");
			date = br.readLine();
		}
		
		return date;
	}
	
	private boolean checkForDateFormat(String date) throws IOException {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		dateFormatter.setLenient(false);
		
		boolean isCorrectDate = false;
		
		try {
			
			dateFormatter.parse(date);
			isCorrectDate = true;
		}
		catch(ParseException pe) {
			
			isCorrectDate = false;
		}

		return isCorrectDate;
	}
}