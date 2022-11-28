package com.push.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<MyErrorDetails> bookException(BookException exp, WebRequest wRequest){
		MyErrorDetails myErrorDetails=new MyErrorDetails(exp.getMessage(),wRequest.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> IllegalArgumentExceptionHandler(IllegalArgumentException exp,
			WebRequest req) {
		MyErrorDetails myErrorDetails=new MyErrorDetails(exp.getMessage(),req.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationException(MethodArgumentNotValidException me){
		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(me.getMessage());
		details.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception exp, WebRequest req) {
		MyErrorDetails myErrorDetails=new MyErrorDetails(exp.getMessage(),req.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<>(myErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
