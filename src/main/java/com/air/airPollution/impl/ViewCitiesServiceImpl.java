package com.air.airPollution.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.HttpResource;

import com.air.airPollution.model.ViewCitiesRequest;
import com.air.airPollution.model.ViewCityResponse;
import com.air.airPollution.service.ViewCitiesService;

@Service
public class ViewCitiesServiceImpl implements ViewCitiesService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<?> viewCities(ViewCitiesRequest request) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		ResponseEntity<?> response;
		try {
		response = restTemplate.exchange("http://api.airvisual.com/v2/cities?state="+request.getState()+"&country="+request.getCountry()+"&key=c0adb993-4294-4eb2-9218-3db4cda39452",
				HttpMethod.GET,entity,ViewCityResponse.class);
		}catch(Exception e) {
			return new ResponseEntity<String>("Invalid Country or state", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
