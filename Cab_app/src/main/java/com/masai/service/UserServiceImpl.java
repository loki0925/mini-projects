package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverNotfound;
import com.masai.exception.LoginException;
import com.masai.exception.UserNotFound;
import com.masai.model.CurrentUserSession;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.DriverDAO;
import com.masai.repository.SessionDAO;
import com.masai.repository.UserDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO udao;
	
	@Autowired
	private SessionDAO sdao;
	
	@Autowired
	private DriverDAO ddao;
	
	

	@Override
	public User RegisterUser(User user) throws UserNotFound {
		// TODO Auto-generated method stub
		List<User> users = udao.findAll();

		if (users.isEmpty())
			throw new UserNotFound("No user records found");
		
		for(User i:users ) {
			if(user.getUserId() == i.getUserId()) {
				throw new UserNotFound(" user already registered with the userId");
			}
		}
		return udao.save(user);
	}

	@Override
	public String loginUser(UserDTO dto) throws LoginException {
		// TODO Auto-generated method stub
		Optional<User> us = udao.findById(dto.getUserId());
		    
		User user = us.get();
		if(user==null)
		{
			throw new LoginException("Please Enter valid Email");
		}
		
		Optional<CurrentUserSession> opt = sdao.findById(user.getUserId());
		
		if(opt.isPresent())
		{
			throw new LoginException("User Already logged in ");
		}
		
		if(user.getPassword().equals(dto.getPassword()))
		{
			String key = RandomString.make(7);
			
			CurrentUserSession cus = new CurrentUserSession(user.getUserId(),key,LocalDateTime.now());
			
			sdao.save(cus);
			
			return "Login succesfully , Unique key :  "+key+" , And details : "+user.toString();
		}
		else
		{
			throw new LoginException("Please Enter a valid password.");
		}
	}

	@Override
	public List<Driver> findDriver(String key) throws DriverNotfound, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession  loggedUser= sdao.findByUuid(key);
		
		if(loggedUser==null)
		{
			throw new LoginException("Invalid user key enter valid user key");
		}
		List<Driver> drivers = ddao.findAll(); 
		if(drivers.size()!=0)
		     return drivers;
		else
		     throw  new DriverNotfound("no driver Available Right Now");
	}

	@Override
	public Driver bookDriver(Integer driverid, Integer source, Integer Destination,String key) throws DriverNotfound, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession  loggedUser= sdao.findByUuid(key);
		
		if(loggedUser==null)
		{
			throw new LoginException("Invalid admin key ,you are not admin");
		}
	   Optional<Driver> dr = ddao.findById(driverid);
	   
	   Driver driver = dr.get();
	   int xcor = driver.getXCordinate();
	   int ycor = driver.getYCordinate();
	   
	   int range =(int) Math.sqrt(((int) Math.pow((source-xcor),2) + (int) Math.pow((Destination-ycor),2)));

		if(range <=5) {
			return driver;
		}
		else 
		   throw  new DriverNotfound("This driver is out of range Please try with different driver");

	}

}
