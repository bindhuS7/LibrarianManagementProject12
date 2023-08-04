package org.jsp.library.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Component
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private  String email;
	private String password;
	private long mobile;
	private int registerNumber;
	private String gender;
	private String token;
	
	
		
	
	
	
	
	
}
