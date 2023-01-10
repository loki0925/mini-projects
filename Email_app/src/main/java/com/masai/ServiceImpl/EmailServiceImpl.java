package com.masai.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.MailNotException;
import com.masai.Model.Email;
import com.masai.Model.User;
import com.masai.Service.EmailService;
import com.masai.repository.UserDAO;

@Service
public class EmailServiceImpl implements EmailService{

	
	@Autowired
	private UserDAO udao;
	
	@Override
	public List<Email> SendMail(User user, Email mail) {
		// TODO Auto-generated method stub
		  User user1 = udao.findByEmail(user.getEmail());
		  List<Email>  mails = user1.getMails(); 
		 
		  mails.add(mail);
		  udao.save(user);
	
		   return mails;
		

	}

	@Override
	public String StarTheMail(User user, Email mail) throws MailNotException {
		// TODO Auto-generated method stub
		  User user1 = udao.findByEmail(user.getEmail());
		  List<Email>  mails = user1.getMails(); 
		  
		  boolean flag = true;
		  for(Email i:mails) {
			  if(mail == i){
			      mail.setStarred(true);
			      flag = false;
			  }
		  }
		  if(flag) {
			  throw new MailNotException("mail you wnat to star is not available");
		  }
		   
		  udao.save(user);
		return "Starred Successfully";
	}

	@Override
	public String DeleteTheMAil(User user, Email mail) throws MailNotException {
		// TODO Auto-generated method stub
		 User user1 = udao.findByEmail(user.getEmail());
		  List<Email>  mails = user1.getMails(); 
		  
		  boolean flag = true;
		  for(Email i:mails) {
			  if(mail == i){
			      mails.remove(mail);
			      flag = false;
			  }
		  }
		  if(flag) {
			  throw new MailNotException("mail you wnat to star is not available");
		  }
		  udao.save(user1);
		   
		return "Starred Successfully";
	}

}
