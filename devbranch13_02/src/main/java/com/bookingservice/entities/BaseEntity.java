package com.bookingservice.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@MappedSuperclass
public abstract class BaseEntity{

	/*The constant serialVersionID*/
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	/*The constant Logger*/
	//private static final Logger LOGGER = LoggerFactory.getLogger(BaseEntity.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "BS_ID")
	private long id;
	
	@JoinColumn(name = "Status_Descrption")
	@JsonIgnore
	private String status;
	
	@Column(name = "Created_Dt")
	@JsonIgnore
	private Date createdDt;
//	
//	@Column(name = "Update_Dt")
//	private Date updateDt;
//	
	@Column(name = "Updated_By")
	@JsonIgnore
	private String updated_By;

	
	
}
