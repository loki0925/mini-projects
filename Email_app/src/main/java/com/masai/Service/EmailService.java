package com.masai.Service;

import java.util.List;

import com.masai.Exception.MailNotException;
import com.masai.Model.Email;
import com.masai.Model.User;

public interface EmailService {

	public List<Email> SendMail(User user,Email mail);
	
	public String StarTheMail(User user, Email mail) throws MailNotException;
	
	public String DeleteTheMAil(User user,Email mail) throws MailNotException;
	
	
}
