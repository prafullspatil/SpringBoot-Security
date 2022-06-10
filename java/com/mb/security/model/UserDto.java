package com.mb.security.model;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.mb.security.validation.ValidPassword;
import com.mb.security.validation.ValidUsername;

public class UserDto
{

	@NotBlank
	@ValidUsername
	private String username;

	@Email
	private String email;

	@ValidPassword
	private String password;

	private Set<String> roles;

	public String getUsername()
	{
		return username;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPassword()
	{
		return password;
	}

	public Set<String> getRoles()
	{
		return roles;
	}

}
