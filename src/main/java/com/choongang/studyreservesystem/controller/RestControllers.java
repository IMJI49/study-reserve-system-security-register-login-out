package com.choongang.studyreservesystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.choongang.studyreservesystem.service.jpa.UserJpaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestControllers {
	private final UserJpaService userService;
	@GetMapping("/check-username")
	public Map<String, Boolean> checkUsername(@RequestParam String username) {
		Map<String, Boolean> check = new HashMap<>();
		check.put("available", !userService.existsByUsername(username));
		return check;
	}
	
	@PostMapping("/find")
	public String findByNameAndEmail(@RequestParam String name, @RequestParam String email) {
		System.out.println(userService.findUserNameFromNameAndEmail(name, email));
		return userService.findUserNameFromNameAndEmail(name, email);
	}
}
