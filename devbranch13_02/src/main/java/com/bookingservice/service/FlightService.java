package com.bookingservice.service;

import com.bookingservice.entities.FlightEntity;

public interface FlightService {

	public Iterable<FlightEntity> viewAllFlight();
	public FlightEntity viewFlight(String flightName);
}
