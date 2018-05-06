package com.luv2code.sprindemo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sergiogp
 *
 */
@Component
public class HappyFortuneService implements FortuneService {
	/**
	 * 
	 */
	@Override
	public String getFortune() {
		return "HappyFortuneService: today is your lucky day";
	}

}
