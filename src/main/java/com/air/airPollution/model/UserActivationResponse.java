package com.air.airPollution.model;

public class UserActivationResponse {
	
	private String status;
	private String message;
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
	public UserActivationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserActivationResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
