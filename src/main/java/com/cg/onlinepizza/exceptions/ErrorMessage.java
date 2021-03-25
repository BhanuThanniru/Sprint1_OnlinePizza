package com.cg.onlinepizza.exceptions;

public class ErrorMessage {
	
	public String status;
	public String message;
	public ErrorMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ErrorMessage() {
		super();
	}
	
	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", message=" + message + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
