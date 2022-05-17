package com.air.airPollution.model;

import java.util.ArrayList;
import java.util.List;

public class AddToFavCitiesRequest {
	List<String> cities = new ArrayList<>();

	public AddToFavCitiesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddToFavCitiesRequest(List<String> cities) {
		super();
		this.cities = cities;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	
}
