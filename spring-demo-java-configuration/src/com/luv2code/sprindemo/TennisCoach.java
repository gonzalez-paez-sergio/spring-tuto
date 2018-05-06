package com.luv2code.sprindemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@PostConstruct
	public void doMyStatupStuff() {
		System.out.println("TennisCoach:  inside of doMyStartupStuff method");
	}

	@PreDestroy
	public void doMyDetroyStuff() {
		System.out.println("TennisCoach:  inside of doMyDetroyStuff method");
	}

	@Override
	public String getDailyWorkout() {
		return "TennisCoach: Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
