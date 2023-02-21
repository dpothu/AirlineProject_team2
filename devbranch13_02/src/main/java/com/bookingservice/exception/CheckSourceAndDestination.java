package com.bookingservice.exception;

@SuppressWarnings("serial")
public class CheckSourceAndDestination extends RuntimeException {

	 public CheckSourceAndDestination() {
		 super(String.format("Source and Destination cannot be same."));
	}
}
