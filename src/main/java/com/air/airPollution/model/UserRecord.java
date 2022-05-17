package com.air.airPollution.model;

public class UserRecord {

	String username;
	String isActive;
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	String email;
	String phone;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserRecord(String username, String isActive, String email, String phone) {
		super();
		this.username = username;
		this.isActive = isActive;
		this.email = email;
		this.phone = phone;
	}
	public UserRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
