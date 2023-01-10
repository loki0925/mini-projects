package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.MailNotException;
import com.masai.Exception.UserNotFound;
import com.masai.Model.Email;
import com.masai.Model.User;
import com.masai.Service.EmailService;


@RestController
@RequestMapping("/masaiMail")
public class EmailController {

	@Autowired
	private EmailService eSer;
	
	
	@PostMapping("/mail")
	public ResponseEntity<List<Email>> GetAllEmails(@RequestBody User user,@RequestBody Email mail) throws UserNotFound {

		return new ResponseEntity<List<Email>>(eSer.SendMail(user, mail), HttpStatus.OK);

	}
	@PostMapping("/Starred")
	public ResponseEntity<String> StarTheMail(@RequestBody User user,@RequestBody Email mail) throws UserNotFound, MailNotException {

		return new ResponseEntity<String>(eSer.StarTheMail(user, mail), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteBook(@RequestBody User user,@RequestBody Email mail) throws MailNotException {

		return new ResponseEntity<String>(eSer.DeleteTheMAil(user, mail), HttpStatus.OK);

	}
}
