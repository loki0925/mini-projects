package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cab {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cabId;
	
	private String carType;
	
	private Integer ratePerKm;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="cab")
	private Driver driver;
}
