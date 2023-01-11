package com.masai.model;

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
	private Integer userid;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
}
