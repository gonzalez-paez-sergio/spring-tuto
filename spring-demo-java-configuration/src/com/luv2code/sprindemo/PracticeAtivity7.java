/**
 * 
 */
package com.luv2code.sprindemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sergiogp
 *
 */
public class PracticeAtivity7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				CodeConfig.class);

		CodeCoach codeCoach = annotationConfigApplicationContext.getBean("codeCoach", CodeCoach.class);

		/// call a method on the beanSys
		System.out.println(codeCoach.getDailyWorkout());
		System.out.println(codeCoach.getDailyFortune());

		annotationConfigApplicationContext.close();
	}

}
