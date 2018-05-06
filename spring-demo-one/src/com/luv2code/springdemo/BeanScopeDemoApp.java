package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] string) {

		// load spring configuration file
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach coach = classPathXmlApplicationContext.getBean("myCoach", Coach.class);

		Coach alphaCoach = classPathXmlApplicationContext.getBean("myCoach", Coach.class);

		System.out.println(coach == alphaCoach);
		System.out.println(coach.equals(alphaCoach));

		System.out.printf("coach:%s\nalphaCoach:%s\n", coach, alphaCoach);

		classPathXmlApplicationContext.close();

	}
}
