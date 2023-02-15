package com.bookingservice.dto;

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
public class BookMainResponse {

	private long bookingId;
	private String pnrNumber;
	private int numberOfPassengers;
	private String flightName;
	private long flightId;
	private long inventoryId;
	private String bookingStatus;
	
	
}
