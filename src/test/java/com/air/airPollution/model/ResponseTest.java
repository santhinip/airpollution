package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTest {
	
	@Test
	public void responseTest() {
		Response res = new Response();
		res.setMessage("message");
		res.setStatus("status");
		assertEquals("message", res.getMessage());
		assertEquals("status", res.getStatus());
	}

}
