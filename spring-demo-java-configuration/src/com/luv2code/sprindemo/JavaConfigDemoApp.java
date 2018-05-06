/**
 * 
 */
package com.luv2code.sprindemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sergiogp
 *
 */
public class JavaConfigDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// read string conffig file
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				SportConfig.class);

		Coach coach = annotationConfigApplicationContext.getBean("tennisCoach", Coach.class);

		/// call a method on the beanSys
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		annotationConfigApplicationContext.close();

	}

}
