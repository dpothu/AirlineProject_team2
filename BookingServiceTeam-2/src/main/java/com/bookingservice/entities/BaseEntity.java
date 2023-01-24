package com.bookingservice.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
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
	private static final long serialVersionUID = -4805605827377858252L;
	
	/*The constant Logger*/
	//private static final Logger LOGGER = LoggerFactory.getLogger(BaseEntity.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BS_ID")
	private long id;
	
	@JoinColumn(name = "Status_Descrption")
	private String status;
	
	@Column(name = "Created_Dt")
	private Date createdDt;
//	
//	@Column(name = "Update_Dt")
//	private Date updateDt;
//	
	@Column(name = "Updated_By")
	private String updated_By;

	
	
}
