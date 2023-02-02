package com.bookingservice.service;

import java.util.List;

import com.bookingservice.entities.PassengersEntity;

public interface PassengersService {

	
	public List<PassengersEntity> viewpassengersWithBookId(long id);

	public Iterable<PassengersEntity> viewAllPassengers();


}
