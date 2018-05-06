package com.luv2code.springsecuirty.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	// add another request mapping for /leaders
	@RequestMapping("/leaders")
	public String showLeaders() {

		return "leaders";
	}

	// add another request mapping for /systems
	@RequestMapping("/systems")
	public String showSystems() {

		return "systems";
	}

	// add another request mapping for /access-denied
	@RequestMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";
	}
}
