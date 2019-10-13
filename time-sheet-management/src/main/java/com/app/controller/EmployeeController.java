package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IEmployeeDao;
import com.app.pojos.Employee;
import com.app.pojos.Login;
import com.app.pojos.Timesheet;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	public IEmployeeDao dao;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee e)
	{
		return dao.addEmployee(e);
	}
	
	@PostMapping("/login")
	public Employee login(@RequestBody Login body)
	{
		return dao.login(body.getEmail(), body.getPassword());
	}
	
	@PostMapping("/addTimeSheet")
	public int addTimeSheet(@RequestBody Timesheet t)
	{
		return dao.addTimeSheet(t);
	}
	
	@GetMapping("/getTimeSheets")
	public List<Timesheet> getTimeSheets(@RequestParam Employee e)
	{
		return dao.getTimesheets(e);
	}
	
}
