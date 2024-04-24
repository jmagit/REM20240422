package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class ControlDeAcceso {
	@Before("execution(* insert(..)) && !com.example.aop.CommonPointcuts.publicMethod()")
	public void antesDelMetodo(JoinPoint jp) {
		System.out.println(">>> No te dejo " + jp.getSignature());
	}
	@After("execution(* insert(..)) || execution(* add(..))")
	public void desDelMetodo(JoinPoint jp) {
		System.out.println(">>> No te dejo tampoco " + jp.getSignature());
	}

}
