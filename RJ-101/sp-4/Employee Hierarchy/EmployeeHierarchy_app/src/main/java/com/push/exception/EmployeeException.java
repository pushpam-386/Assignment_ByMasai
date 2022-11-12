package com.push.exception;

public class EmployeeException extends RuntimeException {
	
	public EmployeeException() {
		
	}
	
	public EmployeeException(String message) {
		System.out.println(message);
	}
}
