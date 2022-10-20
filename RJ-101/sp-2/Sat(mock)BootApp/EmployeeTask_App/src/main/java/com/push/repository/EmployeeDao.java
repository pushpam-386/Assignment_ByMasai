package com.push.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.push.models.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
}
