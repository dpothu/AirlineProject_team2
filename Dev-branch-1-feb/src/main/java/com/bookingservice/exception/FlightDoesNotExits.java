package com.bookingservice.exception;

@SuppressWarnings("serial")
public class FlightDoesNotExits extends RuntimeException{
	
	String givenFlightName;
	public FlightDoesNotExits(String givenFlightName) {
		super(String.format("The Flight name "+givenFlightName+" is not present in predefined Flight List( Or check the spelling of flight Name), So please check the available Flights" ));
		this.givenFlightName = givenFlightName;
	}

}
