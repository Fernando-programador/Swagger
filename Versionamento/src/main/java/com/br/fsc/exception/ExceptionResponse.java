package com.br.fsc.exception;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String Message;
	private String Details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		Message = message;
		Details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return Message;
	}

	public String getDetails() {
		return Details;
	}
	
	
	
	
}
