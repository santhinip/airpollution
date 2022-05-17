package com.air.airPollution.model;

import java.util.ArrayList;
import java.util.List;

public class ViewCityResponse {
	String status;
	List<CityName> data = new ArrayList<>();
	public ViewCityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewCityResponse(String status, List<CityName> data) {
		super();
		this.status = status;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<CityName> getData() {
		return data;
	}
	public void setData(List<CityName> data) {
		this.data = data;
	}
	
}
