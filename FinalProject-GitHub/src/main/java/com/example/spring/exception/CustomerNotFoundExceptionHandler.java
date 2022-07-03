package com.example.spring.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerNotFoundExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> handleException(CustomerNotFoundException e){
		
		CustomerExceptionResponse cust= new CustomerExceptionResponse();
		cust.setDate(new Date());
		cust.setMessage("Not Found");
		cust.setDetail(e.getMessage());
		cust.setServerStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(cust,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> handleException(Exception e){
		
		CustomerExceptionResponse cust= new CustomerExceptionResponse();
		cust.setDate(new Date());
		cust.setMessage("Bad Request");
		cust.setDetail(e.getMessage());
		cust.setServerStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(cust,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> handleException(MethodArgumentNotValidException e){
		
		CustomerExceptionResponse cust= new CustomerExceptionResponse();
		cust.setDate(new Date());
		cust.setMessage("Bad Request");
		cust.setDetail(e.getBindingResult().getFieldError().getDefaultMessage());
		cust.setServerStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(cust,HttpStatus.BAD_REQUEST);
		
	}
	
}

