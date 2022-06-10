package com.mb.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mb.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

	public User getUserByEmail(String email);

}
