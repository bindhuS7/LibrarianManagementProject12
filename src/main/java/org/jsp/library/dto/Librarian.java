package org.jsp.library.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Component
@Validated
@Data
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String name;
	@Digits(integer = 10, fraction = 0)
	private long mobile;
	@Email
	@NotEmpty
	private String email;
	private boolean status;
	@NotEmpty
	private String gender;
	private int otp;
	@NotEmpty
	private String password;
}
