package com.push.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.push.Exception.EmployeeException;
import com.push.Exception.TasksException;
import com.push.models.Employee;
import com.push.models.Tasks;
import com.push.service.EmployeeService;
import com.push.service.TasksService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TasksService tasksService;
	

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws EmployeeException{
		Employee employee2 = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/task")
	public ResponseEntity<Tasks> createTasks(@RequestBody Tasks tasks) throws EmployeeException{
		Tasks tasks2 = tasksService.createTasks(tasks);
		return new ResponseEntity<Tasks>(tasks2,HttpStatus.CREATED);
	}

	@PatchMapping("/tasks/{id}")
	public ResponseEntity<Tasks> updateTask(@PathVariable int id, @RequestBody Tasks tasks) throws TasksException{
		Tasks tasks2 = tasksService.updateTasks(id, tasks);
		return new ResponseEntity<Tasks>(tasks2,HttpStatus.OK);
	}
	
	@DeleteMapping("/tasks/{Id}")
	public ResponseEntity<Tasks> deleteTasksById(@PathVariable int Id) throws TasksException{
		Tasks tasks = tasksService.deleteTasks(Id);
		return new ResponseEntity<Tasks>(tasks,HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{Id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int Id) throws EmployeeException{
		Employee employee = employeeService.deleteEmployeeById(Id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}

	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable int id) throws EmployeeException{
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/tasks?employee_id={id}")
	public ResponseEntity<Tasks> getTasksDetailsByEmployeeId(@RequestParam int id) throws EmployeeException, TasksException{
		Tasks tasks = tasksService.getTaskByEmployeeId(id);
		return new ResponseEntity<Tasks>(tasks, HttpStatus.OK);
	}
	
//	@GetMapping("/tasks/{startDate}/{deadline}")
//	public ResponseEntity<List<Tasks>> getTasksDetailsByStartAndDeadLine(@PathVariable Date startDate,@PathVariable Date deadline) throws EmployeeException, TasksException{
//		List<Tasks> tasks = tasksService.getTaskByStartAndEndDate(startDate,deadline);
//		return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
//	}
	
	@GetMapping("/tasks?order_by=asc")
	public ResponseEntity<Tasks> getTasksDetailsByEmployeeId(@RequestParam String str) throws EmployeeException, TasksException{
		Tasks tasks = tasksService.getTaskByEmployeeId(str);
		return new ResponseEntity<Tasks>(tasks, HttpStatus.OK);
	}

}
