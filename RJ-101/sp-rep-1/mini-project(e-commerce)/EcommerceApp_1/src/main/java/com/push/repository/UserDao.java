package com.push.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public Optional<User> findByMobileNo(String mobileNo);

}
