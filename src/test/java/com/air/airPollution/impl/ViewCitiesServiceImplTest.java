package com.air.airPollution.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.air.airPollution.model.ViewCitiesRequest;

@RunWith(MockitoJUnitRunner.class)
public class ViewCitiesServiceImplTest {

	@InjectMocks
	ViewCitiesServiceImpl mockService;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	public void viewCitiesTest() throws Exception {
		ViewCitiesRequest request = new ViewCitiesRequest();
		request.setCountry("INDIA");
		request.setState("KERALA");
		mockService.viewCities(request);
	}
}
