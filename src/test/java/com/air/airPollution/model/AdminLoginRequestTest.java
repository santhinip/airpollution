package com.air.airPollution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminLoginRequestTest {

	@Test
	public void adminLoginRequestTest() {
		AdminLoginRequest admin = new AdminLoginRequest();
		admin.setPassword("admin");
		admin.setUsername("admin");
		assertEquals("admin", admin.getPassword());
		assertEquals("admin", admin.getUsername());
		admin = new AdminLoginRequest("admin", "admin");
	}
}
