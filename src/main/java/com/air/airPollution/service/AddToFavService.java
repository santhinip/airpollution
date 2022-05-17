package com.air.airPollution.service;

import org.springframework.http.ResponseEntity;

import com.air.airPollution.model.AddToFavCitiesRequest;

public interface AddToFavService {

	public ResponseEntity<String> addToFav(AddToFavCitiesRequest request, String userName);
}
