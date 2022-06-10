package com.mb.security.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.mb.security.validation.ValidPassword;

public class UserCredential
{

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@ValidPassword
	private String password;

	public String getEmail()
	{
		return email;
	}

	public String getPassword()
	{
		return password;
	}
}
