package com.luv2code.sprindemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeConfig {

	@Bean
	public FortuneService codeFortuneService() {
		return new CodeFortuneService();
	}

	@Bean
	public CodeCoach codeCoach() {
		return new CodeCoach(codeFortuneService());
	}

}
