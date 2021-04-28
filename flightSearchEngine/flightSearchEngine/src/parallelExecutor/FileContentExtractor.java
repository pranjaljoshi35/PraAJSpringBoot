package parallelExecutor;

import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.util.HashMap;

public class FileContentExtractor implements Runnable {
	
	File file;
	
	public FileContentExtractor(File file) {
		
		this.file = file;
	}
	
	@Override
	public void run() {
		
		try {
			
			FileReadingEngine obj = FileReadingEngine.getInstance();
			obj.addFlightDetails(extractFileContent(file));
			
		} catch (IOException | CsvException e) {
			
			e.printStackTrace();
		}
	}

	private List<Map<String, String>> extractFileContent(File file) throws IOException, CsvException {
		
		CSVReader csvReader = new CSVReader(new FileReader(file));
		
		List<String[]> fileContent = csvReader.readAll();
		
		return convertFileContentArrayToList(fileContent);
	}
	
	private List<Map<String, String>> convertFileContentArrayToList(List<String[]> fileContent) {
		
		List<Map<String, String>> airLineDetails = new ArrayList<>();
		
		String[] headers = fileContent.get(0)[0].split("\\|");
		
		for(int i = 1; i < fileContent.size(); i++) {
			
			String[] cols = fileContent.get(i)[0].split("\\|");
			
			Map<String, String> keyValueAirlineDetails = new HashMap<>();
			
			for(int j = 0; j < cols.length; j++) {
				
				keyValueAirlineDetails.put(headers[j], cols[j]);
			}
			airLineDetails.add(keyValueAirlineDetails);
		}
		
		return airLineDetails;
	}
}
