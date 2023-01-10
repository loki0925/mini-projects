package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	User findByEmail(String Email);
	

}
