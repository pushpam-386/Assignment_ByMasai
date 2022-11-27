package com.push.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.EmployeeNotExistException;
import com.push.models.Employee;
import com.push.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public boolean deleteEmployee(int empId) throws EmployeeNotExistException {
		Optional<Employee> eOptional=employeeDao.findById(empId);
		if (eOptional.isEmpty()) {
			throw new EmployeeNotExistException("No such employee found in database");
		}
		else {
			employeeDao.delete(eOptional.get());
		}
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> eList=employeeDao.findAll();
		return eList;
	}

	@Override
	public Employee get(int empId) throws EmployeeNotExistException {
		Optional<Employee> eOptional=employeeDao.findById(empId);
		if (eOptional.isEmpty()) {
			throw new EmployeeNotExistException("No such employee found in database");
		}
		return eOptional.get();
	}

}
