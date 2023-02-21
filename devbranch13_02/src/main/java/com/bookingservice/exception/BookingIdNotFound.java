package com.bookingservice.exception;

@SuppressWarnings("serial")
public class BookingIdNotFound extends RuntimeException{

	long id;
	public BookingIdNotFound(long id) {
		super(String.format("There is no Booking with ID: "+id));
		this.id = id;
	}
}
