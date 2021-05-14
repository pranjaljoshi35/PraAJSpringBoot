package com.checkcontrol;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.entities.CSVData;
import com.entities.UserRequest;

public class CheckParsing 
{
	public List<CSVData> checkFlight(UserRequest u,List<CSVData> list) throws ParseException
	{
		List<CSVData> userresult= new ArrayList<CSVData>();
		
		for(CSVData row : list)
		{
			Date requested_date=new SimpleDateFormat("dd/MM/yyyy").parse(u.getFlight_date());
            Date Valid_Till=new SimpleDateFormat("dd-MM-yyyy").parse(row.getValid_till());
			if((u.getArrival_loc().equals(row.getArr_loc())) && (u.getDeparture_loc().equals(row.getDep_loc())) && (Valid_Till.compareTo(requested_date)>=0) && (row.getSeat_av().equalsIgnoreCase("Y"))  && ((u.getFlight_class().equalsIgnoreCase(row.getClass_av()))||(row.getClass_av().equalsIgnoreCase("EB")) )  )
			{
				userresult.add(row);
			}
		}
		
		if(u.getOutput_preference().equalsIgnoreCase("price"))
		{
			Collections.sort(userresult, new Comparator<CSVData>()
			 {
	             public int compare(CSVData o1, CSVData o2) {
	                 return o1.getFare() - o2.getFare();
	             }
	         });
		}
		else
		{
			Collections.sort(userresult, new Comparator<CSVData>()
			 {
	             public int compare(CSVData o1, CSVData o2) {
	            	 	int a=((o1.getFlight_dur() - o2.getFlight_dur())>0)?1:((o1.getFlight_dur() - o2.getFlight_dur())<0)?-1:0;
	                    return a;
	             }
	         });
		}
		 
		return userresult;
	}

	
	
	
	
	
}