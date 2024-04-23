package com.example.domains.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.domains.contracts.services.ClienteService;
import com.example.entities.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	private ClienteRepository dao;

	public ClienteServiceImpl(ClienteRepository dao) {
		super();
		this.dao = dao;
		System.out.println("Constructor ClienteService");
	}
	
	@Override
	public Cliente add(Cliente item) {
		// validar cliente
		var cliente = dao.insert(item);
		// ..
		return cliente;
	}
}
