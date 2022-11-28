package com.push.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.push.exception.UserException;
import com.push.models.User;
import com.push.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	

	@GetMapping("/users")
	public ResponseEntity<List<User>> getallUserDetails() {
		List<User> userL= userService.getAllUsers();
		return new ResponseEntity<List<User>>(userL, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user) {
		User user2= userService.createUserDetails(user);
		return new ResponseEntity<User>(user2, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) throws UserException {
		User user= userService.getUserByUserid(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Integer id) throws UserException {
		User user= userService.deleteByUserID(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
