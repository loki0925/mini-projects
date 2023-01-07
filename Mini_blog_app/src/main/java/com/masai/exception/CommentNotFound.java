package com.masai.exception;

public class CommentNotFound  extends Exception {

	public CommentNotFound(){
		
	}
	public CommentNotFound(String massage) {
		super(massage);
	}
}
