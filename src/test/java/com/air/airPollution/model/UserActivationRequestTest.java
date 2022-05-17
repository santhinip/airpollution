package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserActivationRequestTest {

	UserActivationRequest user = new UserActivationRequest("username");

	@Test
	public void userActivationRequestTest() {
		assertEquals("username", user.getUsername());
	}
}
