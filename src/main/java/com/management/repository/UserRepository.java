package com.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
//	@Query("SELECT u FROM User WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
	Optional<User> findByUsername(String  username);

}
