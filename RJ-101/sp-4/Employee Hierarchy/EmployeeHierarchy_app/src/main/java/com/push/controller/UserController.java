package com.push.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.push.models.Employee;
import com.push.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/create-employees/")
	public ResponseEntity<Employee> createEmployeeDetails(@RequestBody Employee employee ){
		return new ResponseEntity<Employee>(employeeService.createEmployeeDetails(employee),HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/get-employees/{empId}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer empId){
		Employee employee=employeeService.findEmployeeDetail(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get-employee-manager/{empId}")
	public ResponseEntity<Employee> findEmployeeManagerById(@PathVariable Integer empId){
		Employee employee=employeeService.findReportingManagerDetail(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get-all-reportees/{empId}")
	public ResponseEntity<List<Employee>> findReportees(@PathVariable Integer empId){
		List<Employee> employee=employeeService.findAllReportees(empId);
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.BAD_REQUEST);
	}
}
