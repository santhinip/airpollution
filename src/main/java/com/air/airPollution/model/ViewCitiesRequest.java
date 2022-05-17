package com.air.airPollution.model;

public class ViewCitiesRequest {

	String country;
	String state;

	public ViewCitiesRequest(String country, String state) {
		super();
		this.country = country;
		this.state = state;
	}

	public ViewCitiesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
