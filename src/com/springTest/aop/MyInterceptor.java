package com.springTest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zblin
 * @version 2015年6月3日 上午11:58:40
 * @copyright (C)2015 , GRGBanking Equipment Co., Ltd
 */
@Aspect
public class MyInterceptor {

	@Pointcut("execution(* com.springTest.aop.AopTestBean.*(..))")
	private void anyMethod() {
	}// 定义一个切入点

	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name) {
		System.out.println("参数:" + name);
		System.out.println("前置通知");
	}

	@AfterReturning("anyMethod()")
	public void doAfter() {
		System.out.println("后置通知");
	}

	@After("anyMethod()")
	public void after() {
		System.out.println("最终通知");
	}

	@AfterThrowing("anyMethod()")
	public void doAfterThrow() {
		System.out.println("例外通知");
	}

	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		Object object = null;
		System.out.println("进入环绕通知");
		if (false) {
			System.out.println("不执行");
		} else {
			System.out.println("执行");
			object = pjp.proceed();// 执行该方法
		}

		System.out.println("退出方法");
		return object;
	}
}
