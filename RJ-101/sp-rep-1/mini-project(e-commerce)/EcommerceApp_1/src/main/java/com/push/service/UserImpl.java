package com.push.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.UserException;
import com.push.models.SignUpDTO;
import com.push.models.User;
import com.push.repository.UserDao;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public String signUp(SignUpDTO signUp) throws UserException{
		String mobString=signUp.getMobileNo();
		Optional<User> siOptional=userDao.findByMobileNo(mobString);
		if(siOptional.isPresent()) {
			throw new UserException("User already Signed Up");
		}
		else {
			User user= new User();
			user.setUserName(signUp.getUserName());
			user.setEmail(signUp.getEmail());
			user.setMobileNo(signUp.getMobileNo());
			user.setName(signUp.getName());
			user.setUserType("user");
			
			userDao.save(user);
			
			return "New User signedUp";
		}
		
	}
}
