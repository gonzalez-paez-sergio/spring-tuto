package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAnalyticsAspect {
	private static final Logger logger = Logger.getLogger(MyAPIAnalyticsAspect.class.getName());

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void performAPIAnalytics() {
		logger.info("=============>> perform some API Analytics");
	}

}