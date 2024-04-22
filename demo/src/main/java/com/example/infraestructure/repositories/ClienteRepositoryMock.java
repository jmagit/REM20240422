package com.example.infraestructure.repositories;

import java.util.List;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

public class ClienteRepositoryMock implements ClienteRepository {
	@Override
	public List<Cliente> select() {
		System.out.println("Simula la bd");
		return null;
	}
	@Override
	public Cliente insert(Cliente item) {
		System.out.println("Simula la bd");
		return item;
	}
	@Override
	public Cliente update(Cliente item) {
		System.out.println("Simula la bd");
		return item;
	}
	@Override
	public void delete(Cliente item) {
		delete(item.getId());
	}
	@Override
	public void delete(int id) {
		System.out.println("Simula la bd");
	}
}
