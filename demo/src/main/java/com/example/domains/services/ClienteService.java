package com.example.domains.services;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.entities.Cliente;

public class ClienteService {
	private ClienteRepository dao;

	public ClienteService(ClienteRepository dao) {
		super();
		this.dao = dao;
	}
	
	public Cliente add(Cliente item) {
		// validar cliente
		var cliente = dao.insert(item);
		// ..
		return cliente;
	}
}
