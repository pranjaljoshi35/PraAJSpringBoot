package com.nagarro.PraHRApplication.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.PraHRApplication.dao.PraHrDAOb;
import com.nagarro.PraHRApplication.entity.PraHRInfo;


@Controller
public class HRPraController {
	
	@Autowired
	PraHrDAOb dao;
	
	@RequestMapping("/")
	public String home()
	{
		return "Home";
	}
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
	}
	@RequestMapping("/uploadEmployee")
	public String uploadEmployee()
	{
		return "uploadEmployee";
	}
	@RequestMapping("Home")
	public String login()
	{
		return "Home";
	}
	@RequestMapping("validate")
	public String validate(HttpSession session,@RequestParam String userid,@RequestParam String password)
	{
	    System.out.println(userid+" "+password);//just for check
		List<PraHRInfo> hrs=dao.findAll();
		for(PraHRInfo hr:hrs)
		{
			if((hr.getUserid().equals(userid)) &&(hr.getPassword().equals(password)))
			{
				session.setAttribute("name",userid);
				return "redirect:/home";
			}
		 }
		 session.setAttribute("message", "Wrong user-id password!");
	     return "Home";
	}
	
}
