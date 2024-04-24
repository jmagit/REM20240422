package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonPointcuts {
	@Pointcut("execution(public * *(..))")
	public void publicMethod() {}

}
