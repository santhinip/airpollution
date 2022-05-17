package com.air.airPollution.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControllerAdviceTest {

	@InjectMocks 
	ControllerAdvice controllerAdvice;
	
	@Test
	public void getFailureResponseTest() {
		Exception e = new Exception();
		controllerAdvice.getFailureResponse(e);
	}
}
