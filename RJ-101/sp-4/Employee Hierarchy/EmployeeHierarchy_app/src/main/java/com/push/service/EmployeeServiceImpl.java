package com.push.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.exception.EmployeeException;
import com.push.models.Employee;
import com.push.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public Employee createEmployeeDetails(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee, Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeDetail(Integer empId) {
		Optional<Employee> eOptional=employeeDao.findById(empId);
		if(eOptional.isEmpty()){
			throw new EmployeeException("Employee with this id is not there to show");
		}
		return eOptional.get();
	}

	@Override
	public Employee findReportingManagerDetail(Integer empId) {
		Optional<Employee> oEmOptional=employeeDao.findById(empId);
		if (oEmOptional.isEmpty()) {
			throw new EmployeeException("Employee with this id is not there to show Reporting Manager");
		}
		if(oEmOptional.get().getReportingManagerId()==null) {
			throw new EmployeeException("Employee with this id have no Reporting Manager");
		}
		Optional<Employee> eOptional=employeeDao.findById(oEmOptional.get().getReportingManagerId());
		return eOptional.get();
	}

	@Override
	public List<Employee> findAllReportees(Integer empId) {
		Optional<List<Employee>> eOptional=employeeDao.findByReportingManagerId(empId);
		if(eOptional.isEmpty()) {
			throw new EmployeeException("Employee with this id is having no reportees under him");
		}
		return eOptional.get();
	}

}
