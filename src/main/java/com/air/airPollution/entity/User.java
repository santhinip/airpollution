package com.air.airPollution.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String isactive) {
		super();
		this.username = username;
		this.password = password;
		this.isactive = isactive;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	private String username;
	private String password;

	private String isactive;
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

}
