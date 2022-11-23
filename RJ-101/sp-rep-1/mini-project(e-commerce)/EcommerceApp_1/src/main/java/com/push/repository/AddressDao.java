package com.push.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{
	
}
