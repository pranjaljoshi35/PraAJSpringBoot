package searchEngineExecutor;

import java.io.IOException;
import java.text.ParseException;

import com.opencsv.exceptions.CsvException;
import parallelExecutor.FileReadingEngine;

public class StartSearchEngine {

	public static void main(String[] args) throws IOException, CsvException, ParseException {
		
		
		UserAction user = new UserAction();
		user.takeUserInput();
		
		FileReadingEngine obj = FileReadingEngine.getInstance();
		obj.showFlighDetails(user);
	}

}
