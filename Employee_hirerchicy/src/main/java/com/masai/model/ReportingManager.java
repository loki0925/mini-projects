package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "ReportingManager")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ReportingManager {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rmId;
	
	@NotNull
	@JoinTable( name = "Employee", joinColumns = @JoinColumn ( name = "empid"))
	private long empid;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid department")
	@Size(min = 3,max = 20, message = "Invalid department - min 3 letters and max 20 required")
	private String Department;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid designation")
	@Size(min = 2,max = 20, message = "Invalid Desigmation - min 3 letters and max 20 required")
	private String designation;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy = "EmpsTorm",fetch = FetchType.EAGER)
	private List<Employee> emps;
}
