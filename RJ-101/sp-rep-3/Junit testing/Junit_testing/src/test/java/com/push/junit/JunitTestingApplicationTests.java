package com.push.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.push.exception.EmployeeNotExistException;
import com.push.models.Employee;
import com.push.service.EmployeeService;
import com.push.service.EmployeeServiceImpl;

@SpringBootTest
class JunitTestingApplicationTests {
	
	
	EmployeeService employeeService=new EmployeeServiceImpl();
	Employee employee=new Employee(24,"Pushpam","Development");
	Employee employee2=new Employee(27,"Manish","Ms");
	
	
	
	
	
		@Test
		public void addEmployeeTest(){
			assertEquals(employee,employeeService.addEmployee(employee) );
		}
//		@Test
//		public void addEmployeeFailTest(){
//			
//		}
		@Test
		public void deleteEmployeeTest() throws EmployeeNotExistException{
			assertEquals(true, employeeService.deleteEmployee(24));
		}
//		@Test
//		public void deleteEmployeeWithExceptionTest(){
//			
//		}

}
