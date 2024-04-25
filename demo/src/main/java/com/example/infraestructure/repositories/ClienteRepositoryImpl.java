package com.example.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

@Repository
//@Primary
@Profile("prod")
public class ClienteRepositoryImpl implements ClienteRepository {
	private DbConfig cfg;
	public ClienteRepositoryImpl(DbConfig cfg) {
		this.cfg = cfg;
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
		System.out.println("insert " + item.toString());
		cfg.inc();
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
	@Transactional
	public void delete(int id) {
		// Borrar en bd
	}
}
