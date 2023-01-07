package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.PostNotFound;
import com.masai.model.Post;
import com.masai.repository.PostDAO;

@Service
public class PostServiceImpl  implements PostService{

	@Autowired
	private PostDAO pdao;
	
	
	@Override
	public Post getPostById(Integer postid) throws PostNotFound {
		// TODO Auto-generated method stub
		
		Optional<Post> post = pdao.findById(postid);

		return post.orElseThrow(() -> new PostNotFound("No Post records found"));
	}

	@Override
	public Post createPost(Post post) {
		// TODO Auto-generated method stub
		return pdao.save(post);
	}

	@Override
	public String deletePost(Integer postid) throws PostNotFound {
		// TODO Auto-generated method stub
		Optional<Post> post = pdao.findById(postid);

		if (!post.isPresent())
			throw new PostNotFound("No post records found");

		pdao.delete(post.get());

		return "post deleted succefully with ID" + postid;
	}

	@Override
	public Post updatePost(Post post, Integer postid) throws PostNotFound {
		// TODO Auto-generated method stub
		Optional<Post> o_post = pdao.findById(postid);

		if (!o_post.isPresent())
			throw new PostNotFound("No book records found");

		Post epost = o_post.get();
		
		epost.setUser(post.getUser());
		epost.setPostTitle(post.getPostTitle());
		epost.setEmail(post.getEmail());
		epost.setDescription(post.getDescription());
		epost.setCommentList(post.getCommentList());		
		return pdao.save(epost);
	}

	@Override
	public List<Post> getAllPosts() throws PostNotFound {
		// TODO Auto-generated method stub

		List<Post> post = pdao.findAll();

		if (post.isEmpty())
			throw new PostNotFound("No post records found");

		return post;

	}

	

}
