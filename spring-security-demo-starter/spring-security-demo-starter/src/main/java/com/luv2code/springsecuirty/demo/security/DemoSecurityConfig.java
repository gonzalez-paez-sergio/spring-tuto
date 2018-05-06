package com.luv2code.springsecuirty.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();

		authenticationManagerBuilder.inMemoryAuthentication()

				.withUser(userBuilder.username("jhon").password("test123").roles("ADMaIN"))

				.withUser(userBuilder.username("mary").password("test123").roles("DBA"))

				.withUser(userBuilder.username("saul").password("test123").roles("USER"))

		;
	}
}
