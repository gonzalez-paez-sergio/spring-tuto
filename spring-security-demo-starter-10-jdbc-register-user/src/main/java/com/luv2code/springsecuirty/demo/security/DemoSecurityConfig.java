package com.luv2code.springsecuirty.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to out security data source
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// use jdbc authentication
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
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

	/***
	 * 
	 * Create a JDBC User Details Manager bean In our security configuration file,
	 * Demo Security Config.java , we create a JDBC User Details Manager bean. This
	 * is based on our security datasource. It provides access to the database for
	 * creating users. We'll also use Jdbc UserDetailsManager to check if a user
	 * exists. The JdbcUserDetailsManager has all of the low - level JDBC code for
	 * accessing the security database. There is no need for us to create the JDBC
	 * code ... JdbcUserDetailsManager will handle it for us
	 * 
	 * @return
	 */
	@Bean
	public UserDetailsManager userDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}

}
