/**
 * 
 */
package com.luv2code.sprindemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sergiogp
 *
 */
public class SwimJavaConfigDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// read string config file
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				SportConfig.class);

		SwimCoach coach = annotationConfigApplicationContext.getBean("swimCoach", SwimCoach.class);

		/// call a method on the beanSys
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());

		annotationConfigApplicationContext.close();

	}

}
