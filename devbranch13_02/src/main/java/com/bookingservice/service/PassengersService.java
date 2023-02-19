package com.bookingservice.service;

import java.util.List;

import com.bookingservice.dto.PassengersReq;

public interface PassengersService {

	
	public List<PassengersReq> viewpassengersWithBookId(long id);

	public List<PassengersReq> viewAllPassengers();


}
