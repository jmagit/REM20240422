package com.example.infraestructure.repositories;

import java.util.List;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

public class ClienteRepositoryImpl implements ClienteRepository {
	public ClienteRepositoryImpl(DbConfig cfg) {
		System.out.println("Constructor ClienteRepositoryImpl");
	}
	@Override
	public List<Cliente> select() {
		// Consulta la bd
		return null;
	}
	@Override
	public Cliente insert(Cliente item) {
		// Guardar en bd
		return item;
	}
	@Override
	public Cliente update(Cliente item) {
		// Modificar en bd
		return item;
	}
	@Override
	public void delete(Cliente item) {
		delete(item.getId());
	}
	@Override
	public void delete(int id) {
		// Borrar en bd
	}
}
