package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.LoginException;
import com.masai.Exception.MailNotException;
import com.masai.Exception.UserNotFound;
import com.masai.Model.Email;
import com.masai.Model.User;
import com.masai.Model.UserDTO;
import com.masai.Service.UserService;

@RestController
@RequestMapping("/masaiMail")
public class UserController {

	
	@Autowired
	private UserService uSer;
	

	@PostMapping("/register")
	public ResponseEntity<User> RegisterUser(@RequestBody User user) throws UserNotFound {

		return new ResponseEntity<User>(uSer.RegisterUser(user), HttpStatus.CREATED);

	}
	@PostMapping("/login")
	public ResponseEntity<String> LoginUser(@RequestBody UserDTO user) throws LoginException {

		return new ResponseEntity<String>(uSer.loginUser(user), HttpStatus.OK);

	}
	
	@GetMapping("/mail")
	public ResponseEntity<List<Email>> getAllMails(@RequestBody User user) {

		List<Email> mails = uSer.getAllMails(user);

		return new ResponseEntity<List<Email>>(mails, HttpStatus.OK);
	}
	
	@GetMapping("/starred")
	public ResponseEntity<List<Email>> getAllStarredMails(@RequestBody User user) throws MailNotException {

		List<Email> mails = uSer.getAllStarredMails(user);

		return new ResponseEntity<List<Email>>(mails, HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateBook(@RequestBody User user) {

		return new ResponseEntity<User>(uSer.updateUserDetaild(user), HttpStatus.OK);
	}
	
	
}
