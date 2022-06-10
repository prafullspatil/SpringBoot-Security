package com.mb.security.service;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mb.security.entity.User;
import com.mb.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Optional<User> userOptional = userRepository.findByEmail(email);

		if (!userOptional.isPresent())
			throw new UsernameNotFoundException("User not found ");

		return new org.springframework.security.core.userdetails.User(userOptional.get().getUsername(),
				userOptional.get().getPassword(),
				userOptional.get().getRoles()
						.stream().map(role -> new SimpleGrantedAuthority(role))
						.collect(Collectors.toSet()));
	}

}
