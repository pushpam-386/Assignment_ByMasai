package com.push.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	

}
