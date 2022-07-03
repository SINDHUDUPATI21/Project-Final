package com.example.spring.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class FoodExceptionHandler {
	
	
//	Not found Exception
	
	@ExceptionHandler
	public ResponseEntity<FoodExceptionResponse> handleFoodException(NotFoundException e){
		FoodExceptionResponse error = new FoodExceptionResponse();
		error.setDate(new Date());
		error.setServerStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setErrorDetails(null);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);	
	}
	
//	Handle any type of exception
	@ExceptionHandler
	public ResponseEntity<FoodExceptionResponse> handleGlobalException(Exception e){
		FoodExceptionResponse err = new FoodExceptionResponse();
		err.setDate(new Date());
		err.setMessage(e.getMessage());
		err.setServerStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<FoodExceptionResponse> handleValidationException(MethodArgumentNotValidException ex){
		FoodExceptionResponse err = new FoodExceptionResponse();
		err.setDate( new Date());
		err.setErrorDetails(ex.getBindingResult().getFieldError().getDefaultMessage());
		err.setMessage("Validation Failed!!!");
		err.setServerStatus(HttpStatus.BAD_REQUEST.value());
	
		return new ResponseEntity<FoodExceptionResponse>(err,HttpStatus.BAD_REQUEST);
		
		
	}

}
