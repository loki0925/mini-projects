package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.*;

import com.masai.model.Employee;
import com.masai.model.ReportingManager;
import com.masai.repository.EmployeeDAO;
import com.masai.repository.ReportingManagerDAO;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired 
	private EmployeeDAO edao;
	
	@Autowired
	private ReportingManagerDAO rmdao;

	@Override
	public Employee GetEmployeeId(Integer empId) throws NoEmployeeFound {
		// TODO Auto-generated method stub
		Optional<Employee> emp = edao.findById(empId);

		return emp.orElseThrow(() -> new NoEmployeeFound("No employee records found"));
	}

	@Override
	public ReportingManager getEmployeeReportingManager(Integer empId) throws NoEmployeeFound, NoReportingManagerFound {
		// TODO Auto-generated method stub


			Optional<Employee> emp = edao.findById(empId);
			if (!emp.isPresent()) 
				throw new NoEmployeeFound("No emp records found");
	
			Employee empRm = emp.get();
			
			ReportingManager rm  = empRm.getRm();
			
			if(rm.getEmpid() == empRm.getEmpId()) {
				throw new NoReportingManagerFound("This Employeee cant report ownself");	
			}
			
			if(rm.getDesignation().equals("cto") || rm.getDesignation().equals("cto") || rm.getDesignation().equals(null)) {
				
				throw new NoReportingManagerFound("This Employeee id superier they dont have higher Managers");
			}
			
			return rm;
		}
	

	@Override
	public List<Employee> getAllemployeesOfReporter(Integer rmid) throws NoEmployeeFound {
		// TODO Auto-generated method stub
		Optional<ReportingManager> rm = rmdao.findById(rmid);

		if (rm.isEmpty())
			throw new NoEmployeeFound("No emp records found");
           
		ReportingManager rm1 = rm.get();
		List<Employee> list = (List<Employee>) rm1.getEmps();
		return list;
	}

}
