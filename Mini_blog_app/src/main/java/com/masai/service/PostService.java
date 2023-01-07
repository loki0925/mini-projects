package com.masai.service;

import java.util.List;

import com.masai.exception.PostNotFound;
import com.masai.model.Post;

public interface PostService {

	
	
	public Post getPostById(Integer postid) throws PostNotFound;

	public Post createPost(Post post);
	
	public String deletePost(Integer postid) throws PostNotFound;
	
	public Post updatePost(Post post, Integer postid) throws PostNotFound;

	public List<Post> getAllPosts() throws PostNotFound; 
	
}
