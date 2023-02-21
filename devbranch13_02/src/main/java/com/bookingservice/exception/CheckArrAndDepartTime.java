package com.bookingservice.exception;

import java.time.LocalTime;

@SuppressWarnings("serial")
public class CheckArrAndDepartTime extends RuntimeException {

	LocalTime arrTime;
	LocalTime departTime;
	public CheckArrAndDepartTime(LocalTime arrTime,LocalTime departTime) {
		super(String.format("Departure time -> "+departTime+" cannot be after Arrival time -> "+arrTime));
		this.arrTime=arrTime;
		this.departTime=departTime;
	}
}
