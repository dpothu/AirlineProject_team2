package com.bookingservice.entities;

import java.time.LocalTime;
import java.util.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "T_MASTER_BOOKING")
@Component
public class BookingEntity extends BaseEntity{

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	
	private double fareAmount;
	private int noOfPassengers;
	private String source;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private Date departDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private Date arrDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime departTime;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss")
	private LocalTime arrTime;
	private String flightName;
	private String className;
	@OneToMany(targetEntity = PassengersEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Booking_ID", referencedColumnName = "BS_ID")
	private List<PassengersEntity> passengers;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Booking_Flight_ID")
	private FlightEntity bookingFlight;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Booking_Inventory_ID")
	private InventoryEntity bookingInventory;

}
