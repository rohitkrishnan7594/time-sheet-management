package com.app.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
import com.app.pojos.Timesheet;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public String addEmployee(Employee e) {
		try {
			mgr.persist(e);
			return e.getEmployeeId();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Employee login(String email, String password) {
		try {
			String jpql = "select e from Employee e where e.email=:em and e.password=:pwd";
			return mgr.createQuery(jpql, Employee.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int addTimeSheet(Timesheet t) {
		try {
			mgr.persist(t);
			return t.getTimesheetId();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	@Override
	public List<Timesheet> getTimesheets(Employee e) {
		try {
			String jpql = "select t from Timesheet t where t.employee=:e1";
			return mgr.createQuery(jpql,Timesheet.class).setParameter("e1", e).getResultList();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
