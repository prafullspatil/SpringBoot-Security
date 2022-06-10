package com.mb.security.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.mb.security.entity.User;
import com.mb.security.exception.InvalidCredentialsException;
import com.mb.security.exception.ResourceAlreadyExistsException;
import com.mb.security.model.UserCredential;
import com.mb.security.model.UserDto;
import com.mb.security.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	public Object registerUserMethod(UserDto userDto)
	{

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setRoles(userDto.getRoles());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));

		return userRepository.save(user);
	}

	@Override
	public Object registerUser(UserDto userDto)
	{

		if (userRepository.existsByEmail(userDto.getEmail()))
		{
			throw new ResourceAlreadyExistsException("User already exist with email  " + userDto.getEmail());
		}

		return registerUserMethod(userDto);
	}

	@Override
	public String login(UserCredential userCredential) throws InvalidCredentialsException
	{

		Authentication authObject = null;
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getEmail(), userCredential.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authObject);
		}
		catch (BadCredentialsException e)
		{
			throw new InvalidCredentialsException("Invalid credentials");
		}

		Optional<User> optionalUser = userRepository.findByEmail(userCredential.getEmail());

		Set<SimpleGrantedAuthority> roles = optionalUser.get().getRoles()
				.stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toSet());

		return "login Successfully";
	}

	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}

}
