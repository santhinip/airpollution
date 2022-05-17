package com.air.airPollution.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.air.airPollution.entity.FavCities;
import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AddToFavCitiesRequest;
import com.air.airPollution.repo.FavcitiesRepo;
import com.air.airPollution.repo.UserRegistrationRepo;

@RunWith(MockitoJUnitRunner.class)
public class AddToFavServiceImplTest {

	@InjectMocks
	AddToFavServiceImpl mockService;
	
	@Mock
	FavcitiesRepo repo;
	
	@Mock
	UserRegistrationRepo userrepo;
	
	@Test
	public void addToFavTest() {
		AddToFavCitiesRequest request = new AddToFavCitiesRequest();
		List<UserRegistrationRequest> userDetails = new ArrayList<UserRegistrationRequest>();
		UserRegistrationRequest user = new UserRegistrationRequest();
		user.setUsername("ert@gmail.com");
		user.setUserid("2");
		List<String> cities = new ArrayList<>();
		cities.add("qwert");
		cities.add("GF");
		request.setCities(cities);
		userDetails.add(user);
		Mockito.when(userrepo.findAll()).thenReturn(userDetails);
		List<FavCities> citiesDetails = new ArrayList<>();
		FavCities favCities = new FavCities();
		favCities.setCities("werry");
		favCities.setUserid("2");
		citiesDetails.add(favCities);
		Mockito.when(repo.findAll()).thenReturn(citiesDetails);
		Mockito.when(repo.getById(Mockito.any())).thenReturn(favCities);
		mockService.addToFav(request, "ert@gmail.com");
	}
}
