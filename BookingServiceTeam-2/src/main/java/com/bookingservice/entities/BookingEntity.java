package com.bookingservice.entities;

import java.util.*;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
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
	private static final long serialVersionUID = 1L;

	
	private double fareAmount;
	private int noOfPassengers;
	private String source;
	private String destination;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
	private Date departDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date arrDate;
	private String departTime;
	private String arrTime;
	private String flightName;
	
	@OneToMany(targetEntity = PassengersEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Booking_ID", referencedColumnName = "BS_ID")
	private List<PassengersEntity> passengers;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Booking_Flight_ID")
	private FlightEntity bookingFlight;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Booking_Inventory_ID")
	private InventoryEntity bookingInventory;

}
