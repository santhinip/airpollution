package com.air.airPollution.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserActivationResponseTest {
	
	@Test
	public void userActivationResponseTest() {
		UserActivationResponse user = new UserActivationResponse();
		user.setMessage("message");
		user.setStatus("status");
		assertEquals("message", user.getMessage());
		assertEquals("status", user.getStatus());
	}

}
