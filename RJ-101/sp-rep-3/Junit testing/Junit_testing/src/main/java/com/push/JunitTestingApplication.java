package com.push;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.push.exception.EmployeeNotExistException;
import com.push.models.Employee;
import com.push.service.EmployeeService;
import com.push.service.EmployeeServiceImpl;

@SpringBootApplication
public class JunitTestingApplication {

	public static void main(String[] args) throws EmployeeNotExistException {
		SpringApplication.run(JunitTestingApplication.class, args);
		
	}

}
