package com.bookingservice.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.bookingservice.entities.BookingEntity;
import com.bookingservice.entities.PassengersEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookMainReq {

	private double fareAmount;
	private int noOfPassengers;
	private String source;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date departDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date arrDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime departTime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime arrTime;
	private String flightName;
	private String className;
	private List<PassengersEntity> passengers;
	
	public BookingEntity setBookingDetails() {
		BookingEntity booking = new BookingEntity(fareAmount,noOfPassengers, source, destination,departDate, arrDate, departTime, arrTime, flightName, className, passengers, null, null);
		return booking;
	}
}
