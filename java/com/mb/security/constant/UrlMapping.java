package com.mb.security.constant;

public class UrlMapping
{

	private UrlMapping()
	{
		throw new IllegalStateException("Constants class.can't instatiate");
	}

	public static final String BASE_URL = "api/v1";
	public static final String SIGNIN = "signin";
	public static final String SIGNUP = "signup";
	public static final String USERS = "users";

}
