package com.luv2code.springdemo;

public class BaseBallCoach implements Coach {

	private FortuneService fortuneService;

	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "spend 40 min per day on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
