package com.example.infraestructure.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DbConfig {
	private int cont = 0;
	
	public DbConfig() {
		System.out.println("Constructor DbConfig");
	}
	public void inc() {
		cont++;
	}
	public int getCont() { return cont; }
}
