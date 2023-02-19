package com.bookingservice.exception;

@SuppressWarnings("serial")
public class CheckDepartTime extends RuntimeException {

	public CheckDepartTime() {
		super(String.format("Departure cannot be before current time."));
	}
}
