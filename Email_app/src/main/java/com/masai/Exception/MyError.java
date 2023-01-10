package com.masai.Exception;


import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyError {


	private String message;
	
	private String details;
	
	private LocalDateTime time;
}
