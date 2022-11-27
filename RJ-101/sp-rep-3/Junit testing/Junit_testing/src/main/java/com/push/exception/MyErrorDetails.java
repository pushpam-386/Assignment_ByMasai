package com.push.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MyErrorDetails {
	
	private String message;
	private String details;
	private LocalDateTime timeStamp;
	

}
