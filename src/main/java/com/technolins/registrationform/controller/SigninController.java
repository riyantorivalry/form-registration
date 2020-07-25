package com.technolins.registrationform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "signin")
public class SigninController {

	@GetMapping("/")
	String module() {
		return "signin";
	}

}
