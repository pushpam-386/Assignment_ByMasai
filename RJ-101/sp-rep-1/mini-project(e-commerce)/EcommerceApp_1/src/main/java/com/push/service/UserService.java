package com.push.service;

import com.push.exception.UserException;
import com.push.models.User;

public interface UserService {
	
	public String signUp(User signUp) throws UserException;
	

}
