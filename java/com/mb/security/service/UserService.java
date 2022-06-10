package com.mb.security.service;

import java.util.List;
import com.mb.security.entity.User;
import com.mb.security.model.UserCredential;
import com.mb.security.model.UserDto;

public interface UserService
{
	Object registerUser(UserDto userDto);

	String login(UserCredential userCredential);

	List<User> getAllUser();
}
