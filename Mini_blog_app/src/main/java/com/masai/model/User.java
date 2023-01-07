package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "users")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	@NotBlank
	@Size(min =2,message = "enter min  2 chars ")
	private String name;
	 
	@jakarta.validation.constraints.Email
	private String Email;
	
	@Transient
	@NotBlank(message = "enter Post Description ")
	@Size(min =8,message = "enter min  8 chars ")
	private String password;
	
	 
	@OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();

	
	 @OneToMany(mappedBy = "user")
	 private List<Comments> commentList = new ArrayList<>();
}
