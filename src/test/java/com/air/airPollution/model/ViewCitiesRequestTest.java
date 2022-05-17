package com.air.airPollution.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ViewCitiesRequestTest {

	@Test
	public void viewCitiesRequestTest() {
		ViewCitiesRequest view = new ViewCitiesRequest("INDIA", "KERALA");
		assertEquals("INDIA", view.getCountry());
	}
}
