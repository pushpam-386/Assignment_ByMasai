package com.push.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Email;

public interface EmailDao extends JpaRepository<Email, Integer>{

}
