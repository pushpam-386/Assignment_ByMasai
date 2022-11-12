package com.push.service;

import com.push.models.Employee;

import java.util.List;

public interface EmployeeService {
	
	public Employee createEmployeeDetails(Employee employee);
	public Employee updateEmployeeDetails(Employee employee, Integer empId);
	public Employee findEmployeeDetail(Integer empId);
	public Employee findReportingManagerDetail(Integer empId);
	public List<Employee> findAllReportees(Integer empId);

}
