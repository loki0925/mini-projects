package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PostNotFound;
import com.masai.model.Post;
import com.masai.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService PostSer;

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts() throws PostNotFound {

		List<Post> posts = PostSer.getAllPosts();

		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) throws PostNotFound {

		return new ResponseEntity<Post>(PostSer.getPostById(id), HttpStatus.OK);

	}

	@PostMapping("/posts")
	public ResponseEntity<Post> createBook(@RequestBody Post post) {

		return new ResponseEntity<Post>(PostSer.createPost(post), HttpStatus.OK);

	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") Integer id) throws PostNotFound {

		return new ResponseEntity<String>(PostSer.deletePost(id), HttpStatus.OK);

	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updateBook(@RequestBody Post post, @PathVariable("id") Integer id) throws PostNotFound {

		return new ResponseEntity<Post>(PostSer.updatePost(post, id), HttpStatus.OK);
	}
}
