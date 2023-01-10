package com.masai.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String Email;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid Fisrtname - min 3 letters and max 20 required")
	private String Firstname;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3,max = 20, message = "Invalid lastname - min 3 letters and max 20 required")
	private String lastname;
	
	@Size(min = 10,max = 10, message = "Invalid mobile number it Should be Exact 10 digits")
	private String mobilenumber;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}", message = "Invalid Paasword")
	private String password;
	
	@Past
	private LocalDate Dob;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Email> mails;

	
}
