package com.choongang.studyreservesystem.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.choongang.studyreservesystem.dto.UserRegisterDTO;
import com.choongang.studyreservesystem.entity.User;
import com.choongang.studyreservesystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;


	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(
				id + "의 User를 찾을 수 없습니다."));
	}

	public User register(UserRegisterDTO dto) {
		User user = new User();
		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
		}
		user = User.builder().username(dto.getUsername()).password(encoder.encode(dto.getPassword())).role("ROLE_USER")
				.name(dto.getName()).build();
		return userRepository.save(user);
	}

}
