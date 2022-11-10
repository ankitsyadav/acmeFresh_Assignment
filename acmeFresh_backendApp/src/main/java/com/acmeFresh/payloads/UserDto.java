package com.acmeFresh.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {

	private int userId;

	@NotEmpty
	@Size(min = 4, message = "user name must be min of 4 char")
	private String userName;

	@Email(message = "email is not valid")
	private String userEmail;

	@NotEmpty
	@Size(min = 3, max = 10, message = "password must be min of 3 and max of 10 chars")
	private String userPassword;
}
