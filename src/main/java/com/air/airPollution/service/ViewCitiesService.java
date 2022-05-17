package com.air.airPollution.service;

import org.springframework.http.ResponseEntity;

import com.air.airPollution.model.ViewCitiesRequest;

public interface ViewCitiesService {
     public ResponseEntity<?> viewCities(ViewCitiesRequest request) throws Exception;
}
