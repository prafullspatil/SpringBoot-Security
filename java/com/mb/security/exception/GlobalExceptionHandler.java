package com.mb.security.exception;

import java.io.IOException;
import java.util.Date;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.mb.security.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{

	@ExceptionHandler(value = {ResourceAlreadyExistsException.class})
	@ResponseStatus(HttpStatus.OK)
	public ErrorResponse handleResourceAlreadyExistsException(Exception ex)
	{
		return new ErrorResponse(new Date(), "User Already Exists", ex.getMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.OK)
	public ErrorResponse handleResourceNotFoundException(Exception ex)
	{
		return new ErrorResponse(new Date(), "User Already Exists", ex.getMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value = {InvalidCredentialsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidCredentialsException(InvalidCredentialsException ex)
	{
		return new ErrorResponse(new Date(), "Please enter correct credentials", ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(value = {IOException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBadRequest(Exception ex)
	{
		return new ErrorResponse(new Date(), "Bad request", ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(value = {NotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleUnKnownException(Exception ex)
	{
		return new ErrorResponse(new Date(), "Not found", ex.getMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	// @ExceptionHandler(value = {Exception.class})
	// @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	// public ErrorResponse internalServerException(Exception ex)
	// {
	// return new ErrorResponse(new Date(), "Internal server error", ex.getMessage(),
	// HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	// }

	// @ExceptionHandler(value = {AccessDeniedException.class})
	// @ResponseStatus(HttpStatus.FORBIDDEN)
	// public ErrorResponse accessDeniedException(Exception ex)
	// {
	// return new ErrorResponse(new Date(), "Access denied", ex.getMessage(), HttpStatus.FORBIDDEN.value(), ex.getMessage());
	// }

}
