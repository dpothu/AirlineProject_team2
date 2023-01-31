package com.bookingservice.exception;

@SuppressWarnings("serial")
public class PassengerCountDetails extends RuntimeException{

	int passCount;
	int passDetails;
	public PassengerCountDetails(int passCount, int passDetails) {
		super(String.format("The No. of Passengers: "+passCount+" is not matching with passenger details count: "+passDetails));
		this.passCount = passCount;
		this.passDetails = passDetails;
	}
}
