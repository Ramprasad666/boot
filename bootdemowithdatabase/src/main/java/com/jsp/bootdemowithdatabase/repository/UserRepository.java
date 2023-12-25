package com.jsp.bootdemowithdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bootdemowithdatabase.dto.User;

public interface UserRepository  extends JpaRepository<User,Integer>{

	User findByEmailAndPassword(String email,int password);
}
