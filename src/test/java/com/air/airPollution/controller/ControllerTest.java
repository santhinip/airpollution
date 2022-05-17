package com.air.airPollution.controller;

import mockit.integration.junit4.JMockit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AddToFavCitiesRequest;
import com.air.airPollution.model.AdminLoginRequest;
import com.air.airPollution.model.UserActivationRequest;
import com.air.airPollution.model.UserLoginRequest;
import com.air.airPollution.model.UserRecord;
import com.air.airPollution.model.ViewCitiesRequest;
import com.air.airPollution.service.AddToFavService;
import com.air.airPollution.service.UserRegistrationService;
import com.air.airPollution.service.ViewCitiesService;
import com.air.airPollution.util.JWTUtil;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	@InjectMocks 
	Controller mockController;
	
	@Mock
	private JWTUtil jwtTokenUtil;

	@Mock
	private UserRegistrationService registrationService;

	@Mock
	private ViewCitiesService viewService;

	@Mock
	private AddToFavService addToFavService;
	
	@Test
	public void userLoginSTest() throws Exception {
		UserLoginRequest request = new UserLoginRequest();
		request.setPassword("pswd1");
		request.setUsername("ert@gmail.com");
		Mockito.when(registrationService.userLogin(Mockito.any())).thenReturn("Success");
		assertNotNull(mockController.userLogin(request));
		Mockito.when(registrationService.userLogin(Mockito.any())).thenReturn("Failed");
		assertNotNull(mockController.userLogin(request));
		Mockito.when(registrationService.userLogin(Mockito.any())).thenReturn("Inactive");
		assertNotNull(mockController.userLogin(request));
	}
	
	@Test
	public void addUserTest() throws Exception {
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setEmail("ert@gmail.com");
		request.setUsername("ert@gmail.com");
		Mockito.when(registrationService.addUser(Mockito.any())).thenReturn(new ResponseEntity<>("User already exists! ", HttpStatus.BAD_REQUEST));
		assertNotNull(mockController.addUser(request));
	}
	
	@Test
	public void adminLoginTest() throws Exception {
		AdminLoginRequest request = new AdminLoginRequest();
		request.setPassword("admin");
		request.setUsername("admin");
		Mockito.when(registrationService.adminLogin(Mockito.any())).thenReturn("Failed");
		assertNotNull(mockController.adminLogin(request));
		Mockito.when(registrationService.adminLogin(Mockito.any())).thenReturn("Success");
		assertNotNull(mockController.adminLogin(request));
	}
	
	//@Test
	public void viewAllUsersTest() throws Exception {
		List<UserRecord> list = new ArrayList<UserRecord>();
		UserRecord user = new UserRecord();
		user.setEmail("ert@gmail.com");
		list.add(user);
		Mockito.when(registrationService.viewAllUsers()).thenReturn(list);
		assertNotNull(mockController.viewAllUsers(null));
	}
	
	//@Test
	public void activateUserTest() throws Exception {
		UserActivationRequest request = new UserActivationRequest();
		request.setUsername("ert@gmail.com");
		Mockito.when(registrationService.activateUser(Mockito.any())).thenReturn(null);
		assertNull(mockController.activateUser(request, null));
	}
	
	@Test
	public void viewCitiesTest() throws Exception {
		ViewCitiesRequest request = new ViewCitiesRequest();
		request.setCountry("INDIA");
		request.setState("KERALA");
		Mockito.when(viewService.viewCities(Mockito.any())).thenReturn(null);
		mockController.viewCities(request);
	}
	
	//@Test(expected = Exception.class)
	public void addToFavoriteTest() {
		AddToFavCitiesRequest request = new AddToFavCitiesRequest();
		Authentication auth = null;
		Mockito.when(addToFavService.addToFav(Mockito.any(),Mockito.any())).thenReturn(new ResponseEntity<String>("Added city to favorite list", HttpStatus.OK));
		mockController.addToFavorite(request, auth);
	}
}
