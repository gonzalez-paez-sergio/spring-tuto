package com.luv2code.springsecuirty.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to out security data source
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		//use jdbc authentication
		
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
		
		//		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//		authenticationManagerBuilder.inMemoryAuthentication()
//
//				.withUser(userBuilder.username("jhon").password("test123").roles("EMPLOYEE"))
//
//				.withUser(userBuilder.username("mary").password("test123").roles("EMPLOYEE", "ADMIN"))
//
//				.withUser(userBuilder.username("saul").password("test123").roles("EMPLOYEE", "MANAGER"))
//
//		;
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// .anyRequest().authenticated()
				.antMatchers("/").hasRole("EMPLOYEE")

				.antMatchers("/leaders/**").hasRole("MANAGER")

				.antMatchers("/systems/**").hasRole("ADMIN")

				.and()

				.formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()

				.and().logout().permitAll()

				.and()

				.exceptionHandling().accessDeniedPage("/access-denied");

	}
}
