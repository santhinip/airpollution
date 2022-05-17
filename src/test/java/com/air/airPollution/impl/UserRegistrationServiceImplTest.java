package com.air.airPollution.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AdminLoginRequest;
import com.air.airPollution.model.UserActivationRequest;
import com.air.airPollution.model.UserLoginRequest;
import com.air.airPollution.repo.UserRegistrationRepo;
import com.air.airPollution.util.CommonUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceImplTest {
	
	@InjectMocks
	UserRegistrationServiceImpl mockService;
	
	@Mock
	private UserRegistrationRepo repo;
	
	@Mock
	private CommonUtil commonUtil;
	
	@Test
	public void addUserTest() {
		UserRegistrationRequest user = new UserRegistrationRequest();
		List<UserRegistrationRequest> userDetails = new ArrayList<UserRegistrationRequest>();
		user.setEmail("ert@gmail.com");
		user.setEnabled("true");
		user.setName("ert");
		user.setPassword("pswd1");
		user.setRole("user");
		user.setUsername("ert@gmail.com");
		userDetails.add(user);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertNotNull(mockService.addUser(user));
		userDetails.clear();
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertNotNull(mockService.addUser(user));
	}
	
	@Test
	public void userLoginTest() {
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		userLoginRequest.setPassword("pswd1");
		userLoginRequest.setUsername("ert@gmail.com");
		assertEquals("Failed", mockService.userLogin(userLoginRequest));
		UserRegistrationRequest user = new UserRegistrationRequest();
		List<UserRegistrationRequest> userDetails = new ArrayList<UserRegistrationRequest>();
		user.setEmail("ert@gmail.com");
		user.setEnabled("true");
		user.setName("ert");
		user.setPassword("pswd1");
		user.setRole("user");
		user.setUsername("ert@gmail.com");
		userDetails.add(user);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertEquals("Success", mockService.userLogin(userLoginRequest));
		user.setEnabled("false");
		userDetails.clear();
		userDetails.add(user);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertEquals("Inactive", mockService.userLogin(userLoginRequest));
	}
	
	@Test
	public void loadUserByUsernameTest() {
		UserRegistrationRequest userDetails = new UserRegistrationRequest();
		userDetails.setUsername("ert@gmail.com");
		userDetails.setPassword("pswd1");
		Mockito.when(repo.getById(Mockito.any())).thenReturn(userDetails);
		assertNotNull(mockService.loadUserByUsername(userDetails.getUsername()));
	}

	@Test(expected = Exception.class)
	public void viewAllUsersExpTest() throws Exception {
		mockService.viewAllUsers();
	}
	
	@Test
	public void viewAllUsersTest() throws Exception {
		List<UserRegistrationRequest> userDetails = new ArrayList<UserRegistrationRequest>();
		UserRegistrationRequest user = new UserRegistrationRequest();
		user.setEmail("ert@gmail.com");
		user.setName("ert");
		user.setPhone("235435");
		user.setEnabled("true");
		user.setUsername("ert@gmail.com");
		user.setRole("user");
		userDetails.add(user);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertNotNull(mockService.viewAllUsers());
	}
	
	@Test
	public void activateUserTest() {
		UserActivationRequest userActivationRequest = new UserActivationRequest();
		userActivationRequest.setUsername("ert@gmail.com");
		assertNotNull(mockService.activateUser(userActivationRequest));
		List<UserRegistrationRequest> userDetails = new ArrayList<>();
		UserRegistrationRequest userrec = new UserRegistrationRequest();
		userrec.setEnabled("true");
		userDetails.add(userrec);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertNotNull(mockService.activateUser(userActivationRequest));
		userDetails.clear();
		userrec.setEnabled("false");
		userrec.setUsername("ert@gmail.com");
		userDetails.add(userrec);
		Mockito.when(repo.findAll()).thenReturn(userDetails);
		assertNotNull(mockService.activateUser(userActivationRequest));
	}
	
	@Test
	public void adminLoginTest() {
		AdminLoginRequest admin = new AdminLoginRequest();
		admin.setPassword("admin");
		admin.setUsername("admin");
		UserRegistrationRequest userDetails = new UserRegistrationRequest();
		userDetails.setUsername("admin");
		userDetails.setPassword("admin");
		userDetails.setRole("admin");
		Mockito.when(repo.getById(Mockito.any())).thenReturn(userDetails);
		assertEquals("Success", mockService.adminLogin(admin));
	}
}
