/**
 * 
 */
package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

/**
 * @author sergiogp
 *
 */
public class MainDemoApp {

	private static final Logger logger = Logger.getLogger(MainDemoApp.class.getName());

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
		account.setLevel("this is my level");
		account.setName("this is my name");
		accountDAO.addAccount(account, false);
		accountDAO.doWork();

		// call the business method
		membershipDAO.addMySillyMethod("Hello");

		// call the business method
		membershipDAO.goToSleep();
		membershipDAO.getTimeToSleep();

		List<Account> listAccount = accountDAO.findAccount();

		// display the accounts

		logger.info("\n\nafter returning demo App");
		logger.info(listAccount.toString());
		// close the context

		// display the accounts

		logger.info("\n\nafter throwing demo App");
		try {
			listAccount = accountDAO.findAccountWithException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		TrafficFortuneService trafficFortuneService = annotationConfigApplicationContext
				.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("------------->>> Calling getFortune");
		logger.info("My fortune is: " + trafficFortuneService.getFortune(true));

		logger.info("finished");

		// close the context
		annotationConfigApplicationContext.close();
	}

}
