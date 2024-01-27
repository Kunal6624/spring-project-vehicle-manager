package com.sipl.vehicle.manager.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

	@Id
	private long id;

	@NotEmpty
	@Size(min = 3, message = "username must be minimum of 4 characters !!!")
	private String name;

	@Email(message = "email address id not valid!!!")
	private String email;

	@NotEmpty
	@Size(min = 3, max=10,  message = "password must be minimum of 3 characters and maximum of 10 characters !!!")
	private String password;

}
