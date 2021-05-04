package com.mss.hibernate.entity;


import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mss.hibernate.dao.FlightDAOImpl;

public class App 
{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String dep,arr,date,seatClass;
		System.out.println("Welcome to Pranjal Flight Search Engine. Please Enter Your Details: ");
		System.out.print("Departure Location: ");
		dep = scanner.nextLine();		
		System.out.print("Arrival Location: ");
		arr = scanner.nextLine();
		System.out.print("Date(dd-mm-yyyy): ");
		date = scanner.nextLine();;
		System.out.print("Flight Class(E or EB): ");
		seatClass = scanner.nextLine();
		System.out.print("Output Preference(0 - for only fare 1- for both fare and duration): ");
		int output = scanner.nextInt();
		
		try(SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Flight.class).buildSessionFactory()){
			FlightDAOImpl flightDAO = new FlightDAOImpl(factory); 
			//System.out.println(flightDAO.getFlights());
			//new thread to load data
		flightDAO.saveFlight();
			new Thread(() ->{
				flightDAO.saveFlight();
			}).start();
			
			List<Flight> flightList = flightDAO.getFlights(dep.toUpperCase(),arr.toUpperCase(),date,seatClass.toUpperCase(),output);
			if(flightList.size() == 0)
				System.out.println("Sorry! No flight is available as per your input. Thanks for Searching your flights in Pranjal Flight Search Engine.");
			else
				flightList.forEach(System.out::println);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
