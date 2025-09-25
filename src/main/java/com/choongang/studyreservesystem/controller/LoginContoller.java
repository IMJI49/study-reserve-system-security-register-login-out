package com.choongang.studyreservesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginContoller {
	@PostMapping("/login")
	public String loginUser(Model model) {
		
		return "redirect:/";
	}
	@PostMapping("/logout")
	public String logoutUser(Model model) {
		
		return "redirect:/";
	}
}
