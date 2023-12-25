package com.jsp.bootdemowithdatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.jsp.bootdemowithdatabase.helper.ResponseStructure;

@RestControllerAdvice
public class HandlingExceptions {
	
	@ExceptionHandler(value=StudentNotFoundException.class)
	public ResponseStructure<StudentNotFoundException> m1(StudentNotFoundException s){
		ResponseStructure<StudentNotFoundException> response=new ResponseStructure<StudentNotFoundException>();
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		response.setMessage(s.getMessage());
		response.setData(s);
		return response;
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseStructure<UserNotFoundException> m2(UserNotFoundException u){
		ResponseStructure<UserNotFoundException> response1=new ResponseStructure<UserNotFoundException>();
		response1.setStatuscode(HttpStatus.NOT_FOUND.value());
		response1.setMessage(u.getMessage());
		response1.setData(u);
		return response1;

}
}
