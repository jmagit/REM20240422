package com.example.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

@Repository
@Profile("test")
public class ClienteRepositoryMock implements ClienteRepository {
	public ClienteRepositoryMock() {
		System.out.println("Constructor ClienteRepositoryMock");
	}
	@Override
	public List<Cliente> select() {
		System.out.println("Simula la bd");
		return null;
	}
	@Override
	public Cliente insert(Cliente item) {
		System.out.println("Simula insert " + item.toString());
//		System.out.println("Simula la bd");
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
