package com.push.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.repository.PostsDao;

@Service
public class PostsServiceImpl {
	
	@Autowired
	private PostsDao postsDao;

}
