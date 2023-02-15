package com.bookingservice.exception;

@SuppressWarnings("serial")
public class CheckDepartDate extends RuntimeException{

	public CheckDepartDate() {
		super(String.format("Departure cannot be before current date."));
	}
}
