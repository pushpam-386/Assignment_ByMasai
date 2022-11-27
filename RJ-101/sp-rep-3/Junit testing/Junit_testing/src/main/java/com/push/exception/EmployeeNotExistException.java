package com.push.exception;

public class EmployeeNotExistException extends Exception{
	
	public EmployeeNotExistException() {
		
	}
	
	public EmployeeNotExistException(String message) {
		super(message);	
	}

}
