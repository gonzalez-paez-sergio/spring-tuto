package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
	private static final Logger logger = Logger.getLogger(MyCloudLogAspect.class.getName());

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter())")
	public void logToCloudAvice() {
		logger.info("=============>> perform some Cloud Aspects");
	}
}