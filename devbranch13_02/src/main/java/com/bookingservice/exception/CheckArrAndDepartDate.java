package com.bookingservice.exception;

import java.util.Date;

@SuppressWarnings("serial")
public class CheckArrAndDepartDate extends RuntimeException{

	Date arrDate;
	Date departDate;
	public CheckArrAndDepartDate(Date arrDate,Date departDate) {
		super(String.format("Departure date -> "+departDate+" cannot be after Arrival date -> "+arrDate));
		this.arrDate=arrDate;
		this.departDate=departDate;
	}
}
