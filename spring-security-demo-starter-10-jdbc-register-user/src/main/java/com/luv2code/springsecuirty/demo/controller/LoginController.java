package com.luv2code.springsecuirty.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String login() {
		return "fancy-login";
	}
}
