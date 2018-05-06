package com.luv2code.sprindemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "today is a sad day";
	}

}
