package com.luv2code.springdemo;

public class CricketCoach implements Coach { 

	private String emailAddress;
	private String team;

	FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	public CricketCoach() {
		System.out.println("CricketCoach: no-arg constructor");
	}

	/**
	 * @param fortuneService
	 *            the fortuneService to set
	 */
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoah: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoah: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
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
		System.out.println("CricketCoah: inside setter method - setTeam");

		this.team = team;
	}

}
