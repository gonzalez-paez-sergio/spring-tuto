package com.luv2code.sprindemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
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
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
}