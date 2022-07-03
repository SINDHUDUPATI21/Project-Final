package com.example.spring.exception;

import java.util.Date;

public class CustomerExceptionResponse {
	
	private String message;
	private int serverStatus;
	private String detail;
	private Date date;
	
	public CustomerExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerExceptionResponse(String message, int serverStatus, String detail, Date date) {
		super();
		this.message = message;
		this.serverStatus = serverStatus;
		this.detail = detail;
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(int serverStatus) {
		this.serverStatus = serverStatus;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
