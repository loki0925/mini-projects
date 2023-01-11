package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverNotfound;
import com.masai.model.Driver;
import com.masai.repository.DriverDAO;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDAO ddao;
	
	@Override
	public Driver registerDriver(Driver driver) throws DriverNotfound {
		// TODO Auto-generated method stub

		List<Driver> dr = ddao.findAll();
         
		if (dr.isEmpty())
			throw new DriverNotfound("No driver records found");
		
		for(Driver i:dr ) {
			if(driver.getDriverid() == i.getDriverid()) {
				throw new DriverNotfound(" driver already registered with the driverid");
			}
		}
		return ddao.save(driver);
	}

	
}
