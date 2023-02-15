package com.bookingservice.exception;

@SuppressWarnings("serial")
public class SeatsNotAvailable extends RuntimeException {

	int emptySeats;
	int passengers;
	public SeatsNotAvailable(int passengers,int emptySeats) {
		super(String.format("There is no sufficient seats for "+passengers+ " passengers, There are only "+emptySeats+" Empty seats available"));
		this.emptySeats = emptySeats;
		this.passengers = passengers;
	}
}
