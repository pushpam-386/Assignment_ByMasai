package com.push.service;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.Exception.EmployeeException;
import com.push.Exception.TasksException;
import com.push.models.Employee;
import com.push.models.Tasks;
import com.push.repository.EmployeeDao;
import com.push.repository.TasksDao;

import java.util.*;

@Service
public class TasksServiceImpl implements TasksService{
	
	@Autowired 	
	private TasksDao taskDao;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Tasks createTasks(Tasks tasks) {
		taskDao.save(tasks);
		return tasks;
	}

	@Override
	public List<Tasks> getTaskByStartAndEndDate(Date startDate, Date endDate) throws TasksException {
		List<Tasks> tList= taskDao.findByStartDateAndDeadLine(startDate, endDate);
		return tList;
	}

	@Override
	public Tasks updateTasks(int id, Tasks tasks) throws TasksException {
		Optional<Tasks> opt = taskDao.findById(id);
		if (opt.isEmpty()) {
			throw new TasksException("Task not found to update");
		}
		opt.get().setDescription(tasks.getDescription());
		opt.get().setDeadline(tasks.getDeadline());
		opt.get().setStatus(tasks.getStatus());
		opt.get().setId(tasks.getId());
		
		return opt.get();
	}

	@Override
	public Tasks deleteTasks(int id) throws TasksException {
		Optional<Tasks> opt = taskDao.findById(id);
		if (opt.isEmpty()) {
			throw new TasksException("Task not found to Delete");
		}
		taskDao.delete(opt.get());
		return opt.get();
	}

	@Override
	public Tasks getTaskByEmployeeId(int empId) throws EmployeeException, TasksException {
		Optional<Employee> eOptional=employeeDao.findById(empId);
		if (eOptional.isEmpty()) {
			throw new EmployeeException("This Employee for getting Task is not there");
		}
		
		Tasks tasks = eOptional.get().getTasks();
		if (tasks==null) {
			throw new TasksException("No Task is Assigned to this Employee");
		}
		return tasks;
	}

	@Override
	public List<Tasks> findOrderByDeadLineDescOrAscList(Date deadLine) {
		List<Tasks> tList= taskDao.findOrderByDeadLineDescOrAscList(deadLine);
		return tList;
	}

}
