package com.air.airPollution.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favcities")
public class FavCities {
	
	@Id
	String favid;
	public String getFavid() {
		return favid;
	}
	public void setFavid(String favid) {
		this.favid = favid;
	}
	String userid;
	String cities;
	
	public FavCities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FavCities(String favid, String userid, String cities) {
		super();
		this.favid = favid;
		this.userid = userid;
		this.cities = cities;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCities() {
		return cities;
	}
	public void setCities(String cities) {
		this.cities = cities;
	}

}
