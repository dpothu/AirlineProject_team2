package com.bookingservice.dto;

import java.util.List;

import org.springframework.stereotype.Component;

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
@Component
public class BookingResponse{
	private long bookingId;
	private String pnrNo;
	private String sourceCity;
	private String DestinationCity;
	private String flightNumber;
	private int noOfPassengers;
	private String bookingDate;
	private String travelDate;
	private String className;
	private List<PassengersReq> passengers;
}
