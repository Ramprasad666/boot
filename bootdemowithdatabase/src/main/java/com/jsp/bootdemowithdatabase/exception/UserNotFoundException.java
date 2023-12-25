package com.jsp.bootdemowithdatabase.exception;

public class UserNotFoundException extends RuntimeException {

String message;
	
	public UserNotFoundException(String msg) {
		message=msg;
	}
	
@Override
	public String getMessage() {
		return message;
		
	}
}
	


