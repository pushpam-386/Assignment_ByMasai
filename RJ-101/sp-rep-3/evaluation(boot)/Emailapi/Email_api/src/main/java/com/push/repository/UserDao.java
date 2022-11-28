package com.push.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
