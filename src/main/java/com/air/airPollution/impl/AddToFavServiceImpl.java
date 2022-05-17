package com.air.airPollution.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.air.airPollution.entity.FavCities;
import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AddToFavCitiesRequest;
import com.air.airPollution.model.CityName;
import com.air.airPollution.repo.FavcitiesRepo;
import com.air.airPollution.repo.UserRegistrationRepo;
import com.air.airPollution.service.AddToFavService;

@Service
public class AddToFavServiceImpl implements AddToFavService {

	@Autowired
	FavcitiesRepo repo;
	
	@Autowired
	UserRegistrationRepo userrepo;
	
	
	@Override
	public ResponseEntity<String> addToFav(AddToFavCitiesRequest request, String userName) {
		List<UserRegistrationRequest> userDetails = userrepo.findAll();	
		String userid = null;
			Iterator itr = userDetails.iterator();
			while (itr.hasNext()) {
				UserRegistrationRequest us = (UserRegistrationRequest) itr.next();
				if (us.getUsername().equals(userName)) {
					userid = us.getUserid();
					break;
				}
			}
			FavCities fav = new FavCities();
			List<String> cityList = request.getCities();
			String favCities = String.join(",", cityList);
			System.out.println("cities in request  "+ favCities);

 			List<FavCities> citiesDetails = repo.findAll();
			Iterator iterator = citiesDetails.iterator();
			while(iterator.hasNext()) {
				FavCities cities = (FavCities) iterator.next();
				if (null != cities && cities.getUserid().equals(userid)) {
					FavCities retrive = repo.getById(cities.getFavid());
					favCities = retrive.getCities().concat(","+favCities);
					fav.setFavid(cities.getFavid());
					break;
				}
			}
			
			fav.setCities(favCities);
			fav.setUserid(userid);
			repo.save(fav);

		return new ResponseEntity<String>("Added city to favorite list", HttpStatus.OK);
	}
	
}
