package com.push.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.UserException;
import com.push.models.User;
import com.push.repository.AddressDao;
import com.push.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public String signUp(User signUp) throws UserException{
		String mobString=signUp.getMobileNo();
		Optional<User> siOptional=userDao.findByMobileNo(mobString);
		if(siOptional.isPresent()) {
			throw new UserException("User already Signed Up");
		}
		else {
			userDao.save(signUp);
			addressDao.save(signUp.getAddresses());
			return "New User signedUp";
		}
		
	}
	

}
