package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ViewCityResponseTest {

	@Test
	public void viewCityResponseTest() {
		List<CityName> data = new ArrayList<>();
		ViewCityResponse view = new ViewCityResponse();
		view.setData(data);
		view.setStatus("status");
		assertEquals(data, view.getData());
		assertEquals("status",view.getStatus());
		view = new ViewCityResponse("failure", data);
		assertEquals("failure",view.getStatus());
	}
}
