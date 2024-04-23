package com.example.infraestructure.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("prototype")
public class DbConfig {
	private int cont = 0;
	
	public DbConfig() {
		System.out.println("Constructor DbConfig");
	}
	
	@PostConstruct
	private void connect() {
		System.out.println("Me conecto a la bd");
	}
	
	public void inc() {
		cont++;
	}
	public int getCont() { return cont; }
}
