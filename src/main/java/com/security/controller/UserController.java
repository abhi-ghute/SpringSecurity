package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/list")
	public String getUserList() {
		return "userlist";
	}
	

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
}
