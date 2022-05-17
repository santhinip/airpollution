package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRecordTest {

	@Test
	public void userRecordTest() {
		UserRecord user = new UserRecord("username", "true", "email", "32342");
		assertEquals("username", user.getUsername());
		assertEquals("true",user.getIsActive());
		assertEquals("email",user.getEmail());
		assertEquals("32342",user.getPhone());
	}
}
