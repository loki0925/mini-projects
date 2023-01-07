package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CommentNotFound;
import com.masai.exception.PostNotFound;
import com.masai.model.Comments;
import com.masai.model.Post;
import com.masai.model.PostDTO;
import com.masai.service.CommentService;
import com.masai.service.PostService;


@RestController
@RequestMapping("/posts/{postid}")
public class CommentController {

	
	@Autowired
	private CommentService ComSer;

	@GetMapping("/comment")
	public ResponseEntity<List<Comments>> getAllComment() throws CommentNotFound {

		List<Comments> comment = ComSer.getAllComments();

		return new ResponseEntity<List<Comments>>(comment, HttpStatus.OK);
	}

	@GetMapping("/comment/{id}")
	public ResponseEntity<Comments> getCommentById(@PathVariable("id") Integer id) throws PostNotFound, CommentNotFound {

		return new ResponseEntity<Comments>(ComSer.getCommentsById(id), HttpStatus.OK);

	}

	@PostMapping("/comment")
	public ResponseEntity<Comments> createBook(@RequestBody Comments com,@RequestBody PostDTO postdto) {

		return new ResponseEntity<Comments>(ComSer.createComments( postdto, com), HttpStatus.OK);

	}

	@DeleteMapping("/comment/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Integer id) throws PostNotFound, CommentNotFound {

		return new ResponseEntity<String>(ComSer.deleteComments(id), HttpStatus.OK);

	}

	@PutMapping("/Comment/{id}")
	public ResponseEntity<Comments> updateBook(@RequestBody Comments com, @PathVariable("id") Integer id) throws PostNotFound, CommentNotFound {

		return new ResponseEntity<Comments>(ComSer.updateComments(com, id), HttpStatus.OK);
	}
}
