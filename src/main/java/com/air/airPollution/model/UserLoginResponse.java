package com.air.airPollution.model;

public class UserLoginResponse {
	public UserLoginResponse(String jwtToken, String status, String message) {
		super();
		this.jwtToken = jwtToken;
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
	public String getJwtToken() {
		return jwtToken;
	}
	private final String jwtToken;
	private String status;
	private String message;
}
