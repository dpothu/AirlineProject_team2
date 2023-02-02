package com.bookingservice.exception;

@SuppressWarnings("serial")
public class FareNotPresent extends RuntimeException{

	public FareNotPresent(String s) {
		super(String.format(s));
	}
}
