package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.CurrentUserSession;
import com.masai.Model.User;

@Repository
public interface SessionDAO extends JpaRepository<CurrentUserSession, String> {

}
