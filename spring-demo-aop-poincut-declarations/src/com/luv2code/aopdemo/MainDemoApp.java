/**
 * 
 */
package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

/**
 * @author sergiogp
 *
 */
public class MainDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		// get the bean from the spring container
		AccountDAO accountDAO = annotationConfigApplicationContext.getBean("accountDAO", AccountDAO.class);
		// get the bean from the spring container
		MembershipDAO membershipDAO = annotationConfigApplicationContext.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, false);
		accountDAO.doWork();

		// call the business method
		membershipDAO.addMySillyMethod("Hello");

		// call the business method
		membershipDAO.goToSleep();

		// close the context
		annotationConfigApplicationContext.close();
	}

}
