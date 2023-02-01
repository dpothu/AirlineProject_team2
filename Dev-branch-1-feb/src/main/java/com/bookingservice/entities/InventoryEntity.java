package com.bookingservice.entities;


import org.springframework.stereotype.Component;

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
@Component
@Entity
@Table(name = "T_REL_INVENTORY")
public class InventoryEntity {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long inventoryId;
	private String flightName;
	private long flightId;
	private String status;
	private double invoice;
	private String pnr;
	private String journeyToGo;
	
}
