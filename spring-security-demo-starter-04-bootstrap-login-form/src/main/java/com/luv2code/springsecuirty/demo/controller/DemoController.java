package com.luv2code.springsecuirty.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
}
