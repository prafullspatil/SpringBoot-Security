package com.mb.security.controller;

import static com.mb.security.constant.UrlMapping.BASE_URL;
import static com.mb.security.constant.UrlMapping.SIGNIN;
import static com.mb.security.constant.UrlMapping.SIGNUP;
import static com.mb.security.constant.UrlMapping.USERS;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mb.security.entity.User;
import com.mb.security.model.UserCredential;
import com.mb.security.model.UserDto;
import com.mb.security.response.SuccessResponse;
import com.mb.security.service.UserService;

@RestController
@RequestMapping(BASE_URL)
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController
{

	@Autowired
	private UserService userService;

	@PostMapping(SIGNUP)
	public ResponseEntity<SuccessResponse> registerUser(@RequestBody @Valid UserDto userDto)
	{
		SuccessResponse response = SuccessResponse.getInstance();
		response.setData(userService.registerUser(userDto));
		response.setMessage("Success");
		response.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(SIGNIN)
	public ResponseEntity<SuccessResponse> login(@Valid @RequestBody UserCredential userCredential)
	{
		SuccessResponse response = SuccessResponse.getInstance();
		response.setData(userService.login(userCredential));
		response.setMessage("Login successfully");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(USERS)
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
}
