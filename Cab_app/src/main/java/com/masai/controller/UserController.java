package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverNotfound;
import com.masai.exception.LoginException;
import com.masai.exception.UserNotFound;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaiCab")
public class UserController {

	@Autowired
	private UserService uSer;
	

	@PostMapping("/user/register")
	public ResponseEntity<User> RegisterUser(@RequestBody User user) throws UserNotFound {

		return new ResponseEntity<User>(uSer.RegisterUser(user), HttpStatus.CREATED);

	}
	@PostMapping("/user/login")
	public ResponseEntity<String> LoginUser(@RequestBody UserDTO user) throws LoginException {

		return new ResponseEntity<String>(uSer.loginUser(user), HttpStatus.OK);

	}
	
	@GetMapping("/user/findride/{key}")
	public ResponseEntity<List<Driver>> getListOfDriver(@PathVariable("key") String key) throws DriverNotfound, LoginException{
		
		return new ResponseEntity<List<Driver>>(uSer.findDriver(key), HttpStatus.OK);
		
	}
	
	@PutMapping("/user/book/{driverid}/{x}/{y}/{key")
	public  ResponseEntity<Driver> bookDriver(@PathVariable("driverid") Integer driverid,@PathVariable("x") Integer xcor,@PathVariable("y") Integer ycor,@PathVariable("key") String key) throws DriverNotfound, LoginException{
	
		return new ResponseEntity<Driver>(uSer.bookDriver(driverid, xcor, ycor,key), HttpStatus.OK);
		
	}
}
