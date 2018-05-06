package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
	public static void main(String[] string) {

		// load spring configuration file
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");

		// retrieve bean from spring container
		Coach coach = classPathXmlApplicationContext.getBean("myCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());

		classPathXmlApplicationContext.close();
	}
}
