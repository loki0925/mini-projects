package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverNotfound;

import com.masai.model.Driver;

import com.masai.service.DriverService;


@RestController
@RequestMapping("/masaiCab")
public class DriverController {

	@Autowired
	private DriverService dSer;
	

	@PostMapping("/driver/register")
	public ResponseEntity<Driver> RegisterUser(@RequestBody Driver driver) throws DriverNotfound  {

		return new ResponseEntity<Driver>(dSer.registerDriver(driver), HttpStatus.CREATED);

	}
}
