package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FutbolCoach implements Coach {

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "FutbolCoach: Practice your dribling";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

}
