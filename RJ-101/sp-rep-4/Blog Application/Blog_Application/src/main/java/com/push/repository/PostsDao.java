package com.push.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.push.models.Posts;

public interface PostsDao extends PagingAndSortingRepository<Posts, Integer>{

}
