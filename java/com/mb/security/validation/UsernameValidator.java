package com.mb.security.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String>
{

	private String regEx = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context)
	{
		if (username.isBlank())
		{
			return true;
		}

		Pattern pat = Pattern.compile(regEx);
		return pat.matcher(username).matches();

	}
}
