package com.checkcontrol;


import java.util.ArrayList;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CSVDao;
import com.entities.CSVData;
import com.entities.UserRequest;

@Controller
public class praCtrl {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	CSVDao csvDao;
	
	@RequestMapping("/home")
	public String home(Model m)
	{
		String src_dir="C:\\Users\\pranjaljoshi\\Downloads\\FlightCSV";
		ArrayList<String> list_of_file = new ArrayList<String>();
		File folder=null;
		 try 
		 {
	            folder = new File(src_dir);
	            for (File file : folder.listFiles()) 
	            {
	                String name = file.getName();
	                if (!list_of_file.contains(name)) 
	                {
	                	list_of_file.add(name);
	                }
	            }
	     } 
		 catch (Exception e) 
		 {
	            e.printStackTrace();
	     }
		 
		 ArrayList<String> csv_data=new ArrayList<String>();
		 ArrayList<String> arr;
		 if (list_of_file.size() > 0)
		 {
			//create BufferedReader to read csv file
				for (int i = 0; i < list_of_file.size(); i++ )
				{
					try {
						BufferedReader br = new BufferedReader(new FileReader(src_dir+"/"+list_of_file.get(i)));
						String str_line ="";
						br.readLine();
						while((str_line = br.readLine()) != null) {
							if (!csv_data.contains(str_line))
							{
								StringTokenizer token = new StringTokenizer(str_line, "|");
				                arr = new ArrayList(str_line.length());
				                while (token.hasMoreTokens()) {
				                    arr.add(token.nextToken());
				                }
				                Object[] objArr = arr.toArray();
				                
				                
				                // convert Object array to String array
				                String[] str = Arrays.copyOf(objArr, objArr.length,String[].class);
				                
				                CSVData row=new CSVData();
				                row.setFlight_no(str[0]);
				                System.out.println(str[0]);
				                row.setDep_loc(str[1]);
				                row.setArr_loc(str[2]);
				                row.setValid_till(str[3]);
				                row.setFlight_time(Integer.parseInt(str[4]));
				                row.setFlight_dur(Double.parseDouble(str[5]));
				                row.setFare(Integer.parseInt(str[6]));
				                row.setSeat_av(str[7]);
				                row.setClass_av(str[8]);
				                this.csvDao.save(row);
							}
						}
					}
					catch(Exception e)
					{
						
					}
				}
		 }
 
		String nameenter="Pranjal Joshi";
		m.addAttribute("name",nameenter);
		return "home";
	}
	
	@RequestMapping("/search")
	public String search(Model m, HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		UserRequest pra=new UserRequest();
		pra.setDeparture_loc(request.getParameter("deploc"));
		pra.setArrival_loc(request.getParameter("arrloc"));
		pra.setFlight_date(request.getParameter("date"));
		pra.setFlight_class(request.getParameter("cls"));
		pra.setOutput_preference(request.getParameter("outpre"));
		List<CSVData> list=this.csvDao.getAll();
		CheckParsing rc= new CheckParsing();
		List<CSVData> res=rc.checkFlight(pra, list);
		m.addAttribute("rows", res);
		System.out.println(res);
		return "search";
	}
	
}
