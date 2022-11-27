package com.push.service;

import java.util.List;

import com.push.exception.EmployeeNotExistException;
import com.push.models.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public boolean deleteEmployee(int empId)throws EmployeeNotExistException;
	public List<Employee> getAllEmployees();
	public Employee get(int empId)throws EmployeeNotExistException;


}
