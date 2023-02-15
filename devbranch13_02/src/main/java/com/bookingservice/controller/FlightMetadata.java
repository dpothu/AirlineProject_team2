package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.entities.FlightEntity;
import com.bookingservice.service.FlightService;

@RestController
@RequestMapping("/Flight")
public class FlightMetadata {

	@Autowired(required = true)
	FlightService flightService;
	
	
	@RequestMapping(value = "/allFlights",method = RequestMethod.GET)
	public Iterable<FlightEntity> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@RequestMapping(value = "/singleFlight/{flightName}", method = RequestMethod.GET)
	public FlightEntity viewSingleFlight(@PathVariable("flightName") String flightName) {
		return flightService.viewFlight(flightName);
	}
}
