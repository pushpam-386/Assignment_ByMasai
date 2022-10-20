package com.push.service;

import java.util.Date;

import com.push.Exception.EmployeeException;
import com.push.Exception.TasksException;
import com.push.models.Tasks;
import java.util.List;

public interface TasksService {
	public Tasks createTasks(Tasks tasks);
//	public List<Tasks> getTaskByStartAndEndDate(Date startDate,Date deadline)throws TasksException;
	public Tasks updateTasks(int id,Tasks tasks)throws TasksException;
	public Tasks deleteTasks(int id)throws TasksException;
	public List<Tasks> getTaskByEmployeeId(String str)throws EmployeeException, TasksException;
//	public List<Tasks> findOrderByDeadlineDescOrAscList(Date deadline);
}
