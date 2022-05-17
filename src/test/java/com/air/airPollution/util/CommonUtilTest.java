package com.air.airPollution.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommonUtilTest {

	@InjectMocks
	CommonUtil commonUtil;
	
	@Test
	public void getAthoritiesTest() {
		assertNotNull(commonUtil.getAthorities("ADMIN"));
	}
}
