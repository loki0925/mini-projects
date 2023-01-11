package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid Fisrtname - min 3 letters and max 20 required")
	private String firstName;   
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid lastname - min 3 letters and max 20 required")
	private String lastName;
	
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Mobile number must have exact 10 digits")
	private String mobileNumber;
	
	@NotNull
	private int[] currentPosition;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}", message = "Invalid Paasword")
	private String password; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Driver driver;
}
