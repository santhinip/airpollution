package com.air.airPollution.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	
	@Test
	public void userTest() {
		User user = new User();
		user.setIsactive("true");
		user.setPassword("pswd");
		user.setUsername("user");
		assertEquals("true", user.getIsactive());
		assertEquals("pswd", user.getPassword());
		assertEquals("user", user.getUsername());
		user = new User("user1", "pswd1", "false");
		assertEquals("user1", user.getUsername());
	}

}
