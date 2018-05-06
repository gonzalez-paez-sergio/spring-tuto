package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	private static final Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.*(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Signature method = proceedingJoinPoint.getSignature();
		logger.info("------------->> 	@Around advice on method:" + method);
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		logger.info("------------->> 	@Around, duration: " + ((end - begin)));
		return result;

	}

//	@Around(
//
//	"execution(* com.luv2code.aopdemo.service.TrafficFortuneService.*(..))")
//	public Object afterThrowingHandlingExceptionAdvice(
//
//			ProceedingJoinPoint proceedingJoinPoint) {
//
//		logger.info("------------->> 	@Around advice on method " + proceedingJoinPoint.getSignature());
//
//		Object result = null;
//
//		try {
//
//			result = proceedingJoinPoint.proceed();
//		} catch (Throwable e) {
//			// e.printStackTrace();
//			logger.info("catching exception:" + e.getMessage());
//
//			result = "MAJOR ACCIDENT, but no worries, your helicopter in on the way!!";
//		}
//
//		return result;
//	}

	@Around(

	"execution(* com.luv2code.aopdemo.service.TrafficFortuneService.*(..))")
	public Object afterThrowingReTrhowingExceptionAdvice(

			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		logger.info("------------->> 	@Around advice on method " + proceedingJoinPoint.getSignature());

		Object result = null;

		try {

			result = proceedingJoinPoint.proceed();
	
		} catch (Throwable e) {
			// e.printStackTrace();
			logger.info("catching exception:" + e.getMessage());

			throw e;
		}

		return result;
	}

	@Before("execution(* com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage())")
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
		logger.info("=============>> Entering @Before advice on method");

		Signature methodSignature = joinpoint.getSignature();

		logger.info("method signature: " + methodSignature);

		for (Object o : joinpoint.getArgs()) {
			if (o instanceof Account) {
				Account account = (Account) o;
				logger.info("account name: " + account.getName());
				logger.info("account level: " + account.getLevel());
			}
		}

		logger.info("=============>> exit @Before advice on method");
	}

	@AfterReturning(

			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",

			returning = "listAccount")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> listAccount) {
		Signature method = joinPoint.getSignature();

		logger.info("=============>> Entering @AfterReturning advice on method: " + method);
		logger.info("=============>> result is " + listAccount);

		convertAccountNamesToUpperCase(listAccount);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount*(..))")
	public void afterFinallygWithExceptionFindAccountsAdvice(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		logger.info("------------->> @After finally on method: " + method);
	}

	@AfterThrowing(

			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount*(..))"

			, throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception exception) {
		Signature method = joinPoint.getSignature();
		logger.info("------------->> 	@AfterThrowing advice on method " + method + ", with exception: " + exception);
	}

	/**
	 * 
	 * @param listAccount
	 */
	private void convertAccountNamesToUpperCase(List<Account> listAccount) {
		listAccount.forEach(a -> a.setName(a.getName().toUpperCase()));
	}
}