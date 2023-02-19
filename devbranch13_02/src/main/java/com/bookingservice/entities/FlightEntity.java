package com.bookingservice.entities;

import javax.persistence.*;


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
@Entity
@Table(name = "T_REL_Flight_Details")
public class FlightEntity {
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	private String name;
	private int filledseats;
	private int emptyseats;
	private int seatcapacity;
	
}
