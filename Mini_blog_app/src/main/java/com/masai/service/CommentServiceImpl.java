package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentNotFound;
import com.masai.model.Comments;
import com.masai.model.PostDTO;
import com.masai.repository.*;


@Service
public class CommentServiceImpl implements CommentService {

	 @Autowired 
	 private CommentsDAO cdao;
	 
	 @Autowired 
	 private PostDAO pdao;
	
	@Override
	public Comments getCommentsById(Integer commentId) throws CommentNotFound {
		// TODO Auto-generated method stub
		
		Optional<Comments> com = cdao.findById(commentId);

		return com.orElseThrow(() -> new CommentNotFound("No book records found"));
	}

	@Override
	public Comments createComments(PostDTO postdto,Comments comment) {
		// TODO Auto-generated method stub
		
		return cdao.save(comment);
	}

	@Override
	public String deleteComments(Integer comment) throws CommentNotFound {
		// TODO Auto-generated method stub
		Optional<Comments> com =cdao.findById(comment);

		if (!com.isPresent())
			throw new CommentNotFound("No comment records found");

		cdao.delete(com.get());

		return "Book deleted succefully with ID" + comment;
	}

	@Override
	public Comments updateComments(Comments comment, Integer commentId) throws CommentNotFound {
		// TODO Auto-generated method stub
		Optional<Comments> o_com = cdao.findById(commentId);

		if (!o_com.isPresent())
			throw new CommentNotFound("No comment records found");

		Comments ecom = o_com.get();
		ecom.setPost(comment.getPost());
		ecom.setUser(comment.getUser());
		ecom.setCommentid(comment.getCommentid());
		ecom.setCommentDescription(comment.getCommentDescription());

		return cdao.save(ecom);
	}

	@Override
	public List<Comments> getAllComments() throws CommentNotFound {
	

		List<Comments> com = cdao.findAll();

		if (com.isEmpty())
			throw new CommentNotFound("No comment records found");

		return com;
	}

	

}
