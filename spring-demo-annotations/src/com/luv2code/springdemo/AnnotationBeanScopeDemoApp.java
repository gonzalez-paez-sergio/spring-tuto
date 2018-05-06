package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author sergiogp
 *
 */
public class AnnotationBeanScopeDemoApp {
	/**
	 * 
	 * @param string
	 */
	public static void main(String[] string) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Coach coach = classPathXmlApplicationContext.getBean("tennisCoach", Coach.class);

		Coach coach1 = classPathXmlApplicationContext.getBean("tennisCoach", Coach.class);

		System.out.printf("They are equal:%s\n", coach == coach1);
		System.out.printf("coach:%s\n", coach);
		System.out.printf("coach1:%s\n", coach1);

		// Properties p = System.getProperties();
		// System.out.println(p);
		classPathXmlApplicationContext.close();
	}
}
