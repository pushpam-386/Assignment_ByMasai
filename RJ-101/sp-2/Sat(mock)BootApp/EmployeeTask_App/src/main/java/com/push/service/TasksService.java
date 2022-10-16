package com.push.service;

import java.util.*;

import java.util.Date;

import com.push.Exception.EmployeeException;
import com.push.Exception.TasksException;
import com.push.models.Tasks;
import java.util.List;

public interface TasksService {
	public Tasks createTasks(Tasks tasks);
	public List<Tasks> getTaskByStartAndEndDate(Date startDate, java.util.Date deadLine)throws TasksException;
	public Tasks updateTasks(int id,Tasks tasks)throws TasksException;
	public Tasks deleteTasks(int id)throws TasksException;
	public Tasks getTaskByEmployeeId(int empId)throws EmployeeException, TasksException;
	public List<Tasks> findOrderByDeadLineDescOrAscList(Date deadLine);
}
