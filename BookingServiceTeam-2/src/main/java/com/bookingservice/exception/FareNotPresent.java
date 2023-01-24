package com.bookingservice.exception;

public class FareNotPresent extends RuntimeException{

	public FareNotPresent(String s) {
		super(String.format(s));
	}
}
