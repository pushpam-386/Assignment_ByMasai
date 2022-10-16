package com.push.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.Exception.EmployeeException;
import com.push.models.Employee;
import com.push.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired 	
	private EmployeeDao employeeDao;



	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		Optional<Employee> opt = employeeDao.findById(id);
		
		if (!opt.isPresent()) {
			throw new EmployeeException("No such Employee found with this id to show ");
		}
		else {
			
			return opt.get();
		}
	}

	@Override
	public Employee deleteEmployeeById(int id)throws EmployeeException {
		Optional<Employee> opt = employeeDao.findById(id);
		
		if (!opt.isPresent()) {
			throw new EmployeeException("No such Employee found with this id to delete: ");
		}
		else {
			employeeDao.delete(opt.get());
		}
		return opt.get();
	}

}
