package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.*(..))")
	private static void forDaoPackage() {
	};
	// this is where we add all of our related advice for logging

	// lets start with @before advice
	@Before("forDaoPackage()")
	public void AddAccountAdvice() {
		System.out.println("\n=============>> Executing @Before advice on addAccount()");
	}
}