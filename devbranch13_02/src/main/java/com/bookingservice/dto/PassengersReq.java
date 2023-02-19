package com.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PassengersReq {

	private long passengerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNo;
	private long bookingId;
}
