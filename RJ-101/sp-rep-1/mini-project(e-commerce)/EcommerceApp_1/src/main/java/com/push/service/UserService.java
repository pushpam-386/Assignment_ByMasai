package com.push.service;

import com.push.exception.UserException;
import com.push.models.SignUpDTO;

public interface UserService {
	
	public String signUp(SignUpDTO signUp) throws UserException;

}
