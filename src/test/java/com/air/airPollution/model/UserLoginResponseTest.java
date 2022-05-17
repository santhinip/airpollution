package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginResponseTest {

	@Test
	public void userLoginResponseTest() {
		UserLoginResponse user = new UserLoginResponse("jwtToken", "status", "message");
		assertEquals("jwtToken", user.getJwtToken());
		assertEquals("status",user.getStatus());
		assertEquals("message",user.getMessage());
		user.setMessage("success");
		user.setStatus("success");
	}
}
