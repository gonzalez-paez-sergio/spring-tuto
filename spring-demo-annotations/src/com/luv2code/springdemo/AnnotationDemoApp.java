/**
 * 
 */
package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sergiogp
 *
 */
public class AnnotationDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// read string conffig file
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// get the bean from a spring container
		Coach thatSillyCoach = classPathXmlApplicationContext.getBean("tennisCoach", Coach.class);
		/// call a method on the beanSys
		System.out.println(thatSillyCoach.getDailyWorkout());
		System.out.println(thatSillyCoach.getDailyFortune());

		// get the bean from a spring container
		Coach thatCricketCoah = classPathXmlApplicationContext.getBean("cricketCoach", Coach.class);
		/// call a method on the beanSys
		System.out.println(thatCricketCoah.getDailyWorkout());
		System.out.println(thatCricketCoah.getDailyFortune());

		// get the bean from a spring container
		FutbolCoach futbolCoach = classPathXmlApplicationContext.getBean("futbolCoach", FutbolCoach.class);
		/// call a method on the beanSys
		System.out.println(futbolCoach.getDailyWorkout());
		System.out.println(futbolCoach.getDailyFortune());
		System.out.println(futbolCoach.getTeam());
		System.out.println(futbolCoach.getEmail());

		// close thet context

		classPathXmlApplicationContext.close();
	}

}
