package com.mb.security.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse
{
	private String error;
	private Object data;
	private Integer statusCode;
	private String message;

	public static SuccessResponse getInstance()
	{
		SuccessResponse response = new SuccessResponse();
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

	public String getError()
	{
		return error;
	}

	public void setError(String error)
	{
		this.error = error;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public Integer getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(Integer statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}
