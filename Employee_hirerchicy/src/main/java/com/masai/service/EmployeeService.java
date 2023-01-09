package com.masai.service;

import com.masai.exception.NoEmployeeFound;
import com.masai.exception.NoReportingManagerFound;
import com.masai.model.Employee;
import com.masai.model.ReportingManager;

import java.util.*;


public interface EmployeeService {

	public Employee GetEmployeeId(Integer empId) throws NoEmployeeFound;
	
	public ReportingManager getEmployeeReportingManager(Integer empId) throws NoEmployeeFound,NoReportingManagerFound;
	
	public List<Employee> getAllemployeesOfReporter(Integer rmid) throws NoEmployeeFound;
}
