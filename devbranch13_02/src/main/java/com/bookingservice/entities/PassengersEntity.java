package com.bookingservice.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "T_REL_PASSENGERS")
@Component
public class PassengersEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244687830917917479L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "PASS_ID", nullable = false)
	private long id;
	private int passAge;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNo;
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int seatNo;

}
