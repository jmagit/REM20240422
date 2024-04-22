package com.example.domains.contracts.repositories;

import java.util.List;

import com.example.entities.Cliente;

public interface ClienteRepository {

	List<Cliente> select();

	Cliente insert(Cliente item);

	Cliente update(Cliente item);

	void delete(Cliente item);

	void delete(int id);

}