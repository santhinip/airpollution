package com.air.airPollution.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FavCitiesTest {
	
	@Test
	public void favCitiesTest() {
		FavCities fav = new FavCities("1", "1", "ktm,ekm");
		assertEquals("ktm,ekm", fav.getCities());
	}

}
