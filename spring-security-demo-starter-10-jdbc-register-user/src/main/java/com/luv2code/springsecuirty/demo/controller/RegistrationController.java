package com.luv2code.springsecuirty.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecuirty.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(

			@Valid @ModelAttribute("crmUser") CrmUser crmUser,

			BindingResult bindingResult,

			Model model) {

		logger.info("creating user for [" + crmUser.getUsername() + "], with pass [" + crmUser.getPassword() + "]");

		// form validation
		if (bindingResult.hasErrors()) {

			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name/password can not be empty.");

			logger.warning("User name/password can not be empty.");

			return "registration-form";
		}

		if (userDetailsManager.userExists(crmUser.getUsername())) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name already exists!");
			logger.warning("User name already exists!");

			return "registration-form";
		}

		// encrypt the password
		String encodedPassword = passwordEncoder.encode(crmUser.getPassword());

		// prepend the encoding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;

		// give user default role of "employee"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");

		// create user object (from Spring Security framework)
		User tempUser = new User(crmUser.getUsername(), encodedPassword, authorities);

		// save user in the database
		userDetailsManager.createUser(tempUser);

		logger.info("Successfully created user: " + crmUser.getUsername());

		return "registration-confirmation";

	}
}
