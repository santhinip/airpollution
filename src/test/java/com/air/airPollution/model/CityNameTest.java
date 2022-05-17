package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityNameTest {
	
	@Test
	public void cityNameTest() {
		CityName city = new CityName();
		city.setCity("ekm");
		assertEquals("ekm", city.getCity());
		city = new CityName("ktm");
		assertEquals("ktm", city.getCity());
	}

}
