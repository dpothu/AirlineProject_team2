package com.bookingservice.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
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
@Table(name = "T_REL_PASSENGERS")
@Component
public class PassengersEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244687830917917479L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PASS_ID", nullable = false)
	private long id;
	private int passAge;
	private String passName;
	private int seatNo;

}
