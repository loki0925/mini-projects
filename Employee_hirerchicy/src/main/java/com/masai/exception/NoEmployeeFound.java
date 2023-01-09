package com.masai.exception;

public class NoEmployeeFound  extends Exception {

	public NoEmployeeFound(){
		
	}
	public NoEmployeeFound(String massage) {
		super(massage);
	}
}
