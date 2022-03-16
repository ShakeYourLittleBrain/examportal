package com.practice.examportal.utility.wsrest;

import java.time.ZonedDateTime;
import java.util.Optional;

public class UniversalCustomResponseObject {
	
	private Optional<Object> responseObject;
	
	private Optional<String> message;
	
	private Optional<String> exceptionMessage;
	
	private ZonedDateTime responseDate;

	public UniversalCustomResponseObject(Optional<Object> responseObject, Optional<String> message,
			Optional<String> exceptionMessage, ZonedDateTime responseDate) {
		super();
		this.responseObject = responseObject;
		this.message = message;
		this.exceptionMessage = exceptionMessage;
		this.responseDate = responseDate;
	}

	public UniversalCustomResponseObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Optional<Object> getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Optional<Object> responseObject) {
		this.responseObject = responseObject;
	}

	public Optional<String> getMessage() {
		return message;
	}

	public void setMessage(Optional<String> message) {
		this.message = message;
	}

	public Optional<String> getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(Optional<String> exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public ZonedDateTime getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(ZonedDateTime responseDate) {
		this.responseDate = responseDate;
	}

	
	
	
}
