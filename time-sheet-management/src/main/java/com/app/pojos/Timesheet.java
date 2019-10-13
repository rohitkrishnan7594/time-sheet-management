package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name="timesheets")
public class Timesheet {

	private Integer timesheetId;
	private Employee employee;
	private String company, work, description;
	private int time;
	
	public Timesheet() {
	}

	@Id
	@Column(name = "timesheet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
	}

	@ManyToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(length = 50 , nullable = false)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(length = 100 , nullable = false)
	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Column(length = 200 , nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 50 , name = "time_in_mins", nullable = false)
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
