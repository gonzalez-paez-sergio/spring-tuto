package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuratin file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve the bean from the spring container
		// this method behaves the same as getBean(String) but provides a measure of
		// type safety by throwing a BeanNotOfRequiredTypeException if the bean is not
		// of the required type
		Coach coach = context.getBean("myCoach", Coach.class);
		// call the methods on the bean

		// Coach coach1 = (Coach) context.getBean("myCoach");
		// call the methods on the bean

		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		// System.out.println(coach.get);
		// close the context

		// CricketCoach cricketCoach = context.getBean("myCricketCoach",
		// CricketCoach.class);
		CricketCoach cricketCoach  = context.getBean("myCricketCoach", CricketCoach.class);

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		System.out.println(cricketCoach.getTeam());
		System.out.println(cricketCoach.getEmailAddress());

		context.close();

	}

}
