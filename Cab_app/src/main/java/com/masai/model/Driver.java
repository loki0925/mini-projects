package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
   
	@Id
	private int driverid;
	
	private int xCordinate;
	
	private int yCordinate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	
	
}
