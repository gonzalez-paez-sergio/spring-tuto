package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	String[] string = new String[] {

			"RandomFortuneService: happy fortune",

			"RandomFortuneService: lucky day",

			"RandomFortuneService: everything is ok" };

	Random random = new Random();

	@Override
	public String getFortune() {

		return string[random.nextInt(string.length)];
	}

}
