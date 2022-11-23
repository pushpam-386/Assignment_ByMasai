package com.push.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CurrentAdminSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;
	
	private LocalDateTime localDateTime;
	
	@Column(unique =true)
	private Integer userId;
	
	private String uuid;
}
