package com.choongang.studyreservesystem.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.choongang.studyreservesystem.domain.User;
import com.choongang.studyreservesystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserJpaService {
	private final UserRepository userRepository;
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(id + "의 User를 찾을 수 없습니다."));
	}

}
