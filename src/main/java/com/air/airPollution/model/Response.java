package com.air.airPollution.model;

public class Response {
	
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String status, String message) {
		super();
		this.status = status;
		this.message = message;
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
	private String status;
	private String message;
}
