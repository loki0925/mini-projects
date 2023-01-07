package com.masai.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Integer>  {

	 List<Post> findByTitle(String title);
}
