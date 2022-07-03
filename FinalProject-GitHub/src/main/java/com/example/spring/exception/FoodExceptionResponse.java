package com.example.spring.exception;

import java.util.Date;

public class FoodExceptionResponse {
	

	private String errorDetails;
	private Date date;
	private String message;
	private Integer serverStatus;
	public FoodExceptionResponse(String errorDetails, Date date, String message, Integer serverStatus) {
		super();
		this.errorDetails = errorDetails;
		this.date = date;
		this.message = message;
		this.serverStatus = serverStatus;
	}
	public FoodExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(Integer serverStatus) {
		this.serverStatus = serverStatus;
	}

}
