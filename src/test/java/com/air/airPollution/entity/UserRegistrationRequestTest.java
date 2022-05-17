package com.air.airPollution.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationRequestTest {

	@Test
	public void userRegistrationRequestTest() {
		UserRegistrationRequest user = new UserRegistrationRequest("name", "email", "52452452", "username", "password", "enabled", "userid", "role");
		assertEquals("name", user.getName());
	}
}
