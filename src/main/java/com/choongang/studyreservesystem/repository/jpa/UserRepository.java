package com.choongang.studyreservesystem.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.choongang.studyreservesystem.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);
	Optional<User> findBynameAndEmail(String name, String email);
}
