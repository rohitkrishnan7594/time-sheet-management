package com.app.daos;

import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.Timesheet;

public interface IEmployeeDao {

	// Adding employee and returning employee id
	String addEmployee(Employee e);
	
	// Employee logging in using email, password and returning employee object
	Employee login(String email, String password);
	
	// Adding a time sheet entry
	int addTimeSheet(Timesheet t);
	
	// List all time sheet entries
	List<Timesheet> getTimesheets(Employee e);
	
}
