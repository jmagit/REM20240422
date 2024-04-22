package com.example.entities;

import java.util.Objects;

public class Cliente {
	private int id;
	private String nombre, apellidos;
	private boolean conflictivo;
	
	public Cliente() {}
	
	public Cliente(int id, String nombre, String apellidos, boolean conflictivo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.conflictivo = conflictivo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == this.nombre) return;
		if(nombre == null || "".equals(nombre))
			throw new IllegalArgumentException("El nombre es obligatorio");
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isConflictivo() {
		return conflictivo;
	}
	public void setConflictivo(boolean conflictivo) {
		this.conflictivo = conflictivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
		if (!(obj instanceof Cliente))
			return false;
		return id == ((Cliente) obj).id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", conflictivo=" + conflictivo
				+ "]";
	}
	
	
	
	
	
}
