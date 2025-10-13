package com.application.TicketingApp.advice;

import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Error Details")
public class ErrorDetails 
{
	private String statusCode;
	private String msg;
	private LocalDateTime timeStamp;
	
	
	public ErrorDetails() {
		
	}


	public ErrorDetails(String statusCode, String msg, LocalDateTime timeStamp) {
//		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	@XmlElement(name="timeStamp")
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Override
	public String toString() {
		return "ErrorDetails [statusCode=" + statusCode + ", msg=" + msg + ", timeStamp=" + timeStamp + "]";
	}
	

}
