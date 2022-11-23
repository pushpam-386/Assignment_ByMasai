package com.push.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.push.exception.UserException;
import com.push.models.AddressDTO;
import com.push.models.SignUpDTO;
import com.push.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	
	
	@PostMapping("/signUp")
	public ResponseEntity<String> userSignUp(@Valid @RequestBody SignUpDTO signUp) throws UserException{
		String reString=userService.signUp(signUp);
		return new ResponseEntity<String>(reString,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addUserAddress/{mobileNo}")
	public ResponseEntity<String> addUserAddressDetails(@Valid @RequestBody  AddressDTO addressDTO, @PathVariable("mobileNo") String mobileNo) throws UserException{
		String reString=userService.adduserAddressDetails(addressDTO, mobileNo);
		return new ResponseEntity<String>(reString,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<String> userLogin(@Valid @RequestBody  AddressDTO addressDTO, @PathVariable("mobileNo") String mobileNo) throws UserException{
		String reString=userService.adduserAddressDetails(addressDTO, mobileNo);
		return new ResponseEntity<String>(reString,HttpStatus.BAD_REQUEST);
	}
}
