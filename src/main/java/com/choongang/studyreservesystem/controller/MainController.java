package com.choongang.studyreservesystem.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.choongang.studyreservesystem.dto.UserRegisterDTO;
import com.choongang.studyreservesystem.service.UserRegisterService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MainController {
	private final UserRegisterService userRegisterService;

	@GetMapping("/")
	public String home(Model model) {
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority();
		System.out.println(id);
		System.out.println(role);
		model.addAttribute("id", id);
		model.addAttribute("role", role);
		return "home";
	}

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
	@GetMapping("/login")
	public String userLogin() {
		return "log-in";
	}
}
