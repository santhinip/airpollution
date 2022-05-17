package com.air.airPollution.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.air.airPollution.entity.FavCities;

public interface FavcitiesRepo extends JpaRepository<FavCities, String>{
	
}
