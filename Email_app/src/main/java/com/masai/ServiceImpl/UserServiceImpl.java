package com.masai.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.LoginException;
import com.masai.Exception.MailNotException;
import com.masai.Exception.UserNotFound;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Email;
import com.masai.Model.User;
import com.masai.Model.UserDTO;
import com.masai.Service.UserService;
import com.masai.repository.SessionDAO;
import com.masai.repository.UserDAO;

import net.bytebuddy.utility.RandomString;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO udao;
	
	@Autowired
	private SessionDAO sdao;

	@Override
	public User RegisterUser(User user) throws UserNotFound {
		// TODO Auto-generated method stub
		List<User> users = udao.findAll();

		if (users.isEmpty())
			throw new UserNotFound("No user records found");
		
		for(User i:users ) {
			if(user.getEmail() == i.getEmail()) {
				throw new UserNotFound("No user already registered with the email");
			}
		}
		return udao.save(user);


	}

	@Override
	public String loginUser(UserDTO dto) throws LoginException {
		// TODO Auto-generated method stub
		
        User user = udao.findByEmail(dto.getEmail());
		
		if(user==null)
		{
			throw new LoginException("Please Enter valid Email");
		}
		
		
		
		if(user.getPassword().equals(dto.getPassword()))
		{
			String key = RandomString.make(7);
			
			CurrentUserSession cus = new CurrentUserSession(user.getEmail(),key,LocalDateTime.now());
			
			sdao.save(cus);
			
			return "Login succesfully , Unique key :  "+key+" , And details : "+user.toString();
		}
		else
		{
			throw new LoginException("Please Enter a valid password.");
		}
	}

	@Override
	public List<Email> getAllMails(User user) {
		// TODO Auto-generated method stub
		  User user1 = udao.findByEmail(user.getEmail());
		 
		  
		  List<Email>  mails = user1.getMails(); 
	
		   return mails;
	}

	@Override
	public List<Email> getAllStarredMails(User user) throws MailNotException {
		// TODO Auto-generated method stub
		  User user1 = udao.findByEmail(user.getEmail());
			 
		  List<Email>  mails = user1.getMails(); 
		  
		  List<Email> starredMails = null;
		  
		  for(Email i:mails) {
			  if(i.isStarred()==true){
				  starredMails.add(i);
			  }
		  }
		  if(starredMails == null) {
			  throw new MailNotException("User Dont have any Starred Emails");
		  }
		return starredMails;
	}

	@Override
	public User updateUserDetaild(User user) {
		// TODO Auto-generated method stub
		User user1 = udao.findByEmail(user.getEmail());
		
		  user1.setFirstname(user.getFirstname());
		  user1.setLastname(user.getLastname());
		  user1.setMobilenumber(user.getMobilenumber());
		  user1.setPassword(user.getPassword());
		  user1.setDob(user.getDob());
  
		  return udao.save(user1);
		
	}

}
