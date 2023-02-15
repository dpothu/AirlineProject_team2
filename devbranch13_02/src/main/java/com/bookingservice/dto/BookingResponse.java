package com.bookingservice.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.bookingservice.entities.BaseEntity;

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
	private String pnr;
	private String sourceCity;
	private String DestinationCity;
	private String flightNumber;
	private int noOfPassengers;
	private Date bookingDate;
	private Date travelDate;
	private String className;
	
}
