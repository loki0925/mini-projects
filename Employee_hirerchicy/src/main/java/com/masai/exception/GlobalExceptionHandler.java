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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> NoItemFoundException(MethodArgumentNotValidException ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getBindingResult().getFieldError().getDefaultMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> NoItemFoundException(Exception ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoEmployeeFound.class)
	public ResponseEntity<MyError> NoItemFoundException(NoEmployeeFound ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoReportingManagerFound.class)
	public ResponseEntity<MyError> NoReportingManagerFound(NoReportingManagerFound ne, WebRequest wr){
		
		MyError myerr = new MyError(ne.getMessage(), wr.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerr,HttpStatus.BAD_REQUEST);
	}

}
