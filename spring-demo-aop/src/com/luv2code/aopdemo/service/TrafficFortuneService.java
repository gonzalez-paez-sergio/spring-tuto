package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune(boolean bln) throws RuntimeException {

		if (bln)
			throw new RuntimeException("Major accident, Highway is closed!");

		// simulate a delayRuntimeException
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Expect heavy traffic this morning";
	}
}
