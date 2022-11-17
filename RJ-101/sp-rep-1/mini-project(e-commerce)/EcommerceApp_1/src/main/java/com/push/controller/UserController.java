package com.push.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.push.exception.UserException;
import com.push.models.SignUpDTO;
import com.push.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	
	
	@PostMapping("/signUp")
	public ResponseEntity<String> userSignUp(@RequestBody SignUpDTO signUp) throws UserException{
		String reString=userService.signUp(signUp);
		return new ResponseEntity<String>(reString,HttpStatus.BAD_REQUEST);
	}
}
