package com.bookingservice.exception;

@SuppressWarnings("serial")
public class PassengerCountDetails extends RuntimeException{

	public PassengerCountDetails() {
		super(String.format("The No. of Passengers is 0 or not matching with passenger details count. "));
	}
}
