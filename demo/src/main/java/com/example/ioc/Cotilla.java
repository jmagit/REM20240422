package com.example.ioc;

import com.example.infraestructure.repositories.DbConfig;

public class Cotilla {
	private String nombre;
	public Cotilla(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cotilla [nombre=" + nombre + "]";
	}

}
