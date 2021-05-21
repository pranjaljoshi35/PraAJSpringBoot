package com.nagarro.PraEmployeeApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.PraEmployeeApplication.Employee;
import com.nagarro.PraEmployeeApplication.dao.PraEmployeeDAOb;

@RestController
public class PraEmployeeControl {
	
	@Autowired
	PraEmployeeDAOb dao;
	
	@DeleteMapping("/employee/{code}")
	public String deleteEmployee(@PathVariable int code)
	{
		dao.delete(dao.getOne(code));
		return "Deleted";
	}
	
	@PutMapping("/employe/")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);
		return employee;
	}
	
	@GetMapping("/employe/")
	public List<Employee> getEmployee()
	{
		return dao.findAll();
	}
	
	@GetMapping("/employee/{code}")
	public Optional<Employee> getEmployee(@PathVariable("code") int code)
	{
		return dao.findById(code);
	}
	
}


