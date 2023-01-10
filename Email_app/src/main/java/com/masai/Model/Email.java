package com.masai.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	@Id
	private int MailNo;
	
	@Size(min = 3, message = "Mail length Should be atleast Three")
	private String MailDescription;
	
	private boolean starred;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
}
