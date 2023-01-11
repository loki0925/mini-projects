package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyError> LoginException(LoginException ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DriverNotfound.class)
	public ResponseEntity<MyError> DriverNotfound(DriverNotfound ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<MyError> UserNotFound(UserNotFound ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> NoEmployeeFoundException(MethodArgumentNotValidException ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getBindingResult().getFieldError().getDefaultMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> NoEmployeeFoundException(Exception ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}	
}
