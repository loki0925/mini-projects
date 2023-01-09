package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NoEmployeeFound;
import com.masai.exception.NoReportingManagerFound;
import com.masai.model.Employee;
import com.masai.model.ReportingManager;
import com.masai.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empSer;
	
	@GetMapping("/get-employees/{empid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Integer id) throws NoEmployeeFound {

		return new ResponseEntity<Employee>(empSer.GetEmployeeId(id), HttpStatus.OK);

	}
	
	@GetMapping("/get-employee-manager/{empid}")
	public ResponseEntity<ReportingManager> getEmpReportingManager(@PathVariable("id") Integer id) throws NoEmployeeFound, NoReportingManagerFound {
		
		return new ResponseEntity<ReportingManager>(empSer.getEmployeeReportingManager(id), HttpStatus.OK);
	}

	@GetMapping("/get-employee-manager/{empid}")
	public ResponseEntity<List<Employee>> getAllEmployeeToRm(@PathVariable("id") Integer id) throws NoEmployeeFound {
		
		return new ResponseEntity<List<Employee>>((List<Employee>) empSer.getAllemployeesOfReporter(id), HttpStatus.OK);
	}
	
	
	
}
