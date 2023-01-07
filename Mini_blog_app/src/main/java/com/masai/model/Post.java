package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "posts")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private  int postId;
	
	
	@NotBlank(message = "enterPost title")
	@Size(min =2,message = "enter min  2 chars ")
	private String postTitle;
	
	@NotBlank(message = "enter Post Description ")
	@Size(min =2,message = "enter min  2 chars ")
	private String Description;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "postId")
    private  User user;

    
    @jakarta.validation.constraints.Email
	private String Email;
	

    @OneToMany(mappedBy = "post")
    private  List<Comments> commentList = new ArrayList<>();
	
	
}
