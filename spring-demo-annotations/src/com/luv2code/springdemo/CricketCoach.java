package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside set setFortuneService method");
		this.fortuneService = fortuneService;
	}

	public CricketCoach() {
		System.out.println("CricketCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "CricketCoach: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
