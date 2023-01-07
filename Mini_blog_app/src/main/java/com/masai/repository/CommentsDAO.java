package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Comments;

@Repository
public interface CommentsDAO extends JpaRepository<Comments, Integer> {

}
