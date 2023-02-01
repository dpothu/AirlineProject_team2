package com.bookingservice.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingservice.entities.FlightEntity;
import com.bookingservice.exception.FlightDoesNotExits;
import com.bookingservice.repository.FlightRepository;
import com.bookingservice.service.FlightService;


@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightRepository flightRepository;
	
	public Iterable<FlightEntity> viewAllFlight() {
		return flightRepository.findAll();
	}

	@Override
	public FlightEntity viewFlight(String flightName) {
		FlightEntity findByName = flightRepository.findByName(flightName);
		if (findByName != null) {
			return findByName;
		}
		else {
			throw new FlightDoesNotExits(flightName);
	    }
	}
}
