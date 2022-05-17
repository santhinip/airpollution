package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddToFavCitiesRequestTest {

	List<String> cities = new ArrayList<>();
	
	@Test
	public void addToFavCitiesRequestTest() {
		AddToFavCitiesRequest add = new AddToFavCitiesRequest();
		add = new AddToFavCitiesRequest(cities);
		cities.add("name");
		add.setCities(cities);
		assertEquals(cities, add.getCities());
	}
}
