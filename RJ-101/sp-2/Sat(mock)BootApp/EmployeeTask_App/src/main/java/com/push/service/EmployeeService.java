package com.push.service;

import com.push.Exception.EmployeeException;
import com.push.models.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public Employee getEmployeeById(int id)throws EmployeeException;
	public Employee deleteEmployeeById(int id)throws EmployeeException;
	
}
