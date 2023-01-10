package com.masai.Service;

import java.util.List;

import com.masai.Exception.LoginException;
import com.masai.Exception.MailNotException;
import com.masai.Exception.UserNotFound;
import com.masai.Model.Email;
import com.masai.Model.User;
import com.masai.Model.UserDTO;

public interface UserService{

	 public User RegisterUser(User user)  throws UserNotFound ;
	 
     public String loginUser(UserDTO dto) throws LoginException;
     
     public List<Email> getAllMails(User user);
     
     public List<Email> getAllStarredMails(User user) throws MailNotException;
     
     public User updateUserDetaild(User user);
     
     
     
}
