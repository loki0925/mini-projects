package com.masai.service;

import java.awt.print.Book;
import java.util.List;

import com.masai.exception.CommentNotFound;
import com.masai.model.Comments;
import com.masai.model.PostDTO;

public interface CommentService {


	public Comments getCommentsById(Integer commentId) throws CommentNotFound;

	public Comments createComments(PostDTO postdto,Comments comment);
	
	public String deleteComments(Integer comment) throws CommentNotFound;
	
	public Comments updateComments(Comments comment, Integer commentId) throws CommentNotFound;

	public List<Comments> getAllComments() throws CommentNotFound; 
}
