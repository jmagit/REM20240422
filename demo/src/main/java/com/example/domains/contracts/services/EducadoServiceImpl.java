package com.example.domains.contracts.services;

import com.example.infraestructure.repositories.DbConfig;

public class EducadoServiceImpl implements EducadoService {
	private String nombre;
	private DbConfig cfg;

	public EducadoServiceImpl(String nombre, DbConfig cfg) {
		super();
		this.nombre = nombre;
		this.cfg = cfg;
	}
	
	@Override
	public void saluda() {
		System.out.println("Hola " + nombre + " " + cfg.getCont());
	}
	@Override
	public void despide() {
		System.out.println("Adios " + nombre);
	}
}
