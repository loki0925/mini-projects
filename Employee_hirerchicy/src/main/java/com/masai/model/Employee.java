package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn (name = "empid")
	private long empId;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid Firstname")
	@Size(min = 3,max = 20, message = "Invalid firstname - min 3 letters and max 20 required")
	private String firstname;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid Lastname")
	@Size(min = 3,max = 20, message = "Invalid lastname - min 3 letters and max 20 required")
	private String lastname;
	
	@Email
	private String Email;
	
	@Size(min = 10,max = 10, message = "Invalid phone - enter exact 10 Digits")
	private String phone;
	
	@NotNull
	private double salary;
	
 	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
	private ReportingManager rm;
}
