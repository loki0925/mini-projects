package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "comments")
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int commentid;
	
    @NotBlank(message = "ener comment destcription")
	@Size(min =2,message = "enter min  2 chars ")
	private String commentDescription;
	
 
    @ManyToOne
    private Post post;;
    
    @ManyToOne
    private User user;
}
