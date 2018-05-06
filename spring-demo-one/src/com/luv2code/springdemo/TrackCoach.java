package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.setFortuneService(fortuneService);
	}

	public TrackCoach() {
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "just do it";
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doStartStuff");
	}

	// add a destroy method
	public static void doMyCleanupStuff(boolean string) {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

}
