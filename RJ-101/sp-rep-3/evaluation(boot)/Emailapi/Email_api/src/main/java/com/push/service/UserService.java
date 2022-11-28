package com.push.service;

import java.util.List;

import com.push.exception.EmailException;
import com.push.exception.UserException;
import com.push.models.Email;
import com.push.models.User;


public interface UserService {
	
	public List<User> getAllUsers();
	public User createUserDetails(User user);
	public User getUserByUserid(Integer userid)throws UserException;
	public User deleteByUserID(Integer userId)throws UserException;
	public Email getEmailDetailByUser(Integer userId, Integer emailId)throws EmailException, UserException;
	public User createEmailForUser(Integer userId, Email email);

}
