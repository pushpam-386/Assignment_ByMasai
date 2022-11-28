package com.push.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.EmailException;
import com.push.exception.UserException;
import com.push.models.Email;
import com.push.models.User;
import com.push.repository.EmailDao;
import com.push.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired private UserDao userDao;
	@Autowired private EmailDao emailDao;

	@Override
	public List<User> getAllUsers() {
		List<User> usersL=userDao.findAll();
		return usersL;
	}

	@Override
	public User createUserDetails(User user) {
		 userDao.save(user);
		 emailDao.save(user.getEmail());
		return user;
	}

	@Override
	public User getUserByUserid(Integer userid) throws UserException {
		Optional<User> uOptional= userDao.findById(userid);
		if (uOptional.isEmpty()) {
			throw new UserException("User not found");
		}
		return uOptional.get();
	}

	@Override
	public User deleteByUserID(Integer userId) throws UserException {
		Optional<User> uOptional= userDao.findById(userId);
		if (uOptional.isEmpty()) {
			throw new UserException("User not found to delete");
		}
		 userDao.delete(uOptional.get());
		 return uOptional.get();
	}

	@Override
	public Email getEmailDetailByUser(Integer userId, Integer emailId) throws EmailException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createEmailForUser(Integer userId, Email email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
