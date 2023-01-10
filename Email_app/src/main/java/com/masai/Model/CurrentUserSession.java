package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private String Email;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
}