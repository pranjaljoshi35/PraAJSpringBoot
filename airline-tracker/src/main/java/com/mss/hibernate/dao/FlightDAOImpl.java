package com.mss.hibernate.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.mss.hibernate.entity.Flight;


public class FlightDAOImpl implements FlightDAO{
	
	private SessionFactory sessionFactory;
	
	
	
	public FlightDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Flight> getFlights() {			
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query<Flight> query = currentSession.createQuery("from Flight");
		List<Flight> flights = query.getResultList();
		currentSession.close();
		return flights;
	}
	

	public List<Flight> getFlights(String dep, String arr, String date, String seatClass,int pref){
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		String sortCol = "fare";
		if(pref == 1)
			sortCol += ",flight_dur";
		Query query = currentSession.createQuery("from Flight f where f.depLOC =: dep AND f.arrLOC =: arr AND f.validTill =: date"
				+ " AND f.seatClass =: seatClass"
				+" order by " + sortCol);
		query.setParameter("dep",dep);
		query.setParameter("arr",arr);
		query.setParameter("date",date);
		query.setParameter("seatClass",seatClass);		
		List<Flight> flights = query.getResultList();
		currentSession.getTransaction().commit();
		currentSession.close();
		if(!seatClass.equals("E")) {
			for(Flight f: flights)
				f.setFare(1.4 * f.getFare());
		}	
		return flights;
	}
	
	public void saveFlight() {
		
		File[] csvFiles = new File("C:\\Users\\Admin\\Downloads\\FlightCSV\\")
				.listFiles((dir,name) -> 
		        name.endsWith(".csv"));
		List<String> fileNames = new ArrayList<>();
		for(File file: csvFiles)
			if(file.isFile())
				fileNames.add(file.getName());
		for(String fileName : fileNames) {
			String path = "C:\\Users\\Admin\\Downloads\\FlightCSV\\" + fileName;
		
		File file = new File(path);
		try(BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line = bf.readLine();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightsearchengine","root","root");
			Statement stmnt = connection.createStatement();
			while((line = bf.readLine()) != null) {
				String[] par = line.split("\\|");
				Flight flight = new Flight(par[0],par[1],par[2],par[3],par[4],Double.parseDouble(par[5]),Double.parseDouble(par[6]),par[7],par[8]);
				String sql = "insert into airlines values('"+par[0]+"','"+par[1]+"','"+par[2]+"','"+par[3]+"','"+par[4]+"',"+Double.parseDouble(par[5])+","
				+Double.parseDouble(par[6])+",'"+par[7]+"','"+par[8]+"')";	
				ResultSet res = stmnt.executeQuery("select * from airlines where flight_no = " +"'"+par[0]+"'");
				if(res.next())
					continue;
				stmnt.execute(sql);				
			}
			connection.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}}
		
		//sessionFactory.close();
	}


}
