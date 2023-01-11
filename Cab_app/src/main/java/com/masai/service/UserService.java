package com.masai.service;

import java.util.List;

import com.masai.exception.DriverNotfound;
import com.masai.exception.LoginException;
import com.masai.exception.UserNotFound;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserDTO;

public interface UserService {

	 public User RegisterUser(User user)  throws UserNotFound ;
	 
     public String loginUser(UserDTO dto) throws LoginException;
     
     public List<Driver> findDriver(String key) throws DriverNotfound, LoginException;
     
     public Driver bookDriver(Integer driverid,Integer source,Integer Destination,String key) throws DriverNotfound, LoginException;

     
     
}
