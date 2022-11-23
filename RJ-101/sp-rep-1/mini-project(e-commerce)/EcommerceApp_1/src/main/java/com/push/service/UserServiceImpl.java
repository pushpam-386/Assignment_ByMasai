package com.push.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.UserException;
import com.push.models.Address;
import com.push.models.AddressDTO;
import com.push.models.SignUpDTO;
import com.push.models.User;
import com.push.repository.AddressDao;
import com.push.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
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
			userDao.save(signUpDTOToUser(signUp));
			return "New User signedUp";
		}
		
	}
	
	private User signUpDTOToUser(SignUpDTO signUp) {
		User user= new User();
		user.setUserName(signUp.getUserName());
		user.setEmail(signUp.getEmail());
		user.setMobileNo(signUp.getMobileNo());
		user.setName(signUp.getName());
		user.setUserType("user");
		List<Address> addresses = new ArrayList<>();
		for(AddressDTO addressDTO : signUp.getAddresses()) {
			Address address=new Address();
			address.setDistrict(addressDTO.getDistrict());
			address.setHouseOrApartment(addressDTO.getHouseOrApartment());
			address.setLandmark(addressDTO.getLandmark());
			address.setPincode(addressDTO.getPincode());
			address.setState(addressDTO.getState());
			addresses.add(address);
		}
		user.setAddresses(addresses);
		return user;
	}

	@Override
	public String adduserAddressDetails(AddressDTO addressDTO, String mobileNo) throws UserException {
		Optional<User> uOptional=userDao.findByMobileNo(mobileNo);
		if (uOptional.isEmpty()) {
			throw new UserException("No Such user found by this Mobile NO");
		}
		else {
			Address address=new Address();
			address.setDistrict(addressDTO.getDistrict());
			address.setHouseOrApartment(addressDTO.getHouseOrApartment());
			address.setLandmark(addressDTO.getLandmark());
			address.setPincode(addressDTO.getPincode());
			address.setState(addressDTO.getState());
			uOptional.get().getAddresses().add(address);
			userDao.save(uOptional.get());
		}
		return "address added to this user";
	}
}
