package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addMySillyMethod(String string) {
		System.out.println(getClass() + ": Doing stuff, adding a membership account");
	}

	public void goToSleep() {
		System.out.println(getClass() + ": Go to Sleep now...");
	}

	public void getTimeToSleep() {
		System.out.println(getClass() + ": getTimeToSleep: Time to Sleep is... now");
	}
}
