package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LuvAopExpressions {

	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.*(..))")
	public static void forDaoPackage() {
	};

	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.get*(..))")
	public static void onlyGetter() {
	};

	@Pointcut("execution (* com.luv2code.aopdemo.dao.*.set*(..))")
	public static void onlySetter() {
	};

	@Pointcut("forDaoPackage() && !(onlyGetter() || onlySetter())")
	public void forDaoPackageNoGetterSetter() {
	};

}
