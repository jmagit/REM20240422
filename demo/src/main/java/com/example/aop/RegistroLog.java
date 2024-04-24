package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

@Component
@Aspect
public class RegistroLog {
	@Pointcut("execution(public * com.example..*.*(..))")
	public void miPuntoDeCorte() {}
	
//	@Before("miPuntoDeCorte() && args(item)")
//	public void antesDelMetodo(JoinPoint jp, Cliente item) {
//		System.out.println(">>> Soy un consejo antesDelMetodo " + jp.getSignature());
//		System.out.println(">>> Me han pasado " + item.toString());
//	}
//	
//	@After("miPuntoDeCorte()")
//	public void despuesDelMetodo(JoinPoint jp) {
//		System.out.println(">>> Soy un consejo despuesDelMetodo " + jp.getSignature());
//	}
//
//	@After("@annotation(com.example.aop.Cerrado)")
//	public void despuesDelAnotado(JoinPoint jp) {
//		System.out.println(">>>>>> Esta anotado " + jp.getSignature());
//	}
	
//	@After("execution(public * com.example.domains.contracts.repositories.ClienteRepository.insert(..))")
//	public void updateDelMetodo(JoinPoint jp) {
//		((ClienteRepository)jp.getTarget()).delete(0);
//		System.out.println(">>> He borrado " + jp.getSignature());
//	}
	
	@Around(value = "execution(public com.example.entities.Cliente add(..))")
	public Cliente envuelve(ProceedingJoinPoint jp) throws Throwable {
		System.out.println(">>> Antes de " + jp.getSignature());
//		if(true) return null;
		var cliente = (Cliente)jp.proceed();
		System.out.println(">>> Despues de " + jp.getSignature());
		cliente.setNombre(cliente.getNombre().toUpperCase());
		return cliente;
	}
	
	@DeclareParents(value="com.example.domains.services.ClienteService*", defaultImpl=DefaultVisible.class)
	public static Visible mixin;

}
