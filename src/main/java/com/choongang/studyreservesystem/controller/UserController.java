package com.choongang.studyreservesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choongang.studyreservesystem.dto.UserRegisterDTO;
import com.choongang.studyreservesystem.service.UserRegisterService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserRegisterService userRegisterService;
	@GetMapping("/register")
	public String userRegister(Model model) {
		UserRegisterDTO dto = new UserRegisterDTO();
		model.addAttribute("user", dto);
		return "register";
	}
	@PostMapping("/register")
	public String postMethodName(UserRegisterDTO dto, Model model) {
		userRegisterService.register(dto);
		return "redirect:/";
	}
	@PostMapping("/login")
	public String loginUser(Model model) {
		
		return "redirect:/";
	}
	@PostMapping("/logout")
	public String logoutUser(Model model) {
		
		return "redirect:/";
	}
	
}
