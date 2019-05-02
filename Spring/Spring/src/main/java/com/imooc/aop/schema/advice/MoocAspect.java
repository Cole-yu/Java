package com.imooc.aop.schema.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MoocAspect {
	
	public void before() {
		System.out.println("MoocAspect before.");
	}
	
	// 方法正常返回之后
	public void afterReturning() {
		System.out.println("MoocAspect afterReturning.");
	}
	
	//抛出异常之后
	public void afterThrowing() {
		System.out.println("MoocAspect afterThrowing.");
	}
	
	public void after() {
		System.out.println("MoocAspect after.");
	}
	
	public Object around(ProceedingJoinPoint pjp) {
		Object obj = null;
		try {
			System.out.println("MoocAspect around 1.");
			obj = pjp.proceed();
			System.out.println("MoocAspect around 2.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	// 通知里面使用参数的方式
	public Object aroundInit(ProceedingJoinPoint pjp, String bizName, int times) {
		System.out.println(bizName + " -- " + times);
		Object obj = null;
		try {
			System.out.println("MoocAspect aroundInit 1.");
			obj = pjp.proceed();
			System.out.println("MoocAspect aroundInit 2.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
