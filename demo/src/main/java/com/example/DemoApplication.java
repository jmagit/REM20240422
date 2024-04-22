package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.domains.services.ClienteService;
import com.example.entities.Cliente;
import com.example.infraestructure.repositories.ClienteRepositoryImpl;
import com.example.infraestructure.repositories.ClienteRepositoryMock;
import com.example.infraestructure.repositories.DbConfig;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	ClienteService srv;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		
		var cliente = new Cliente();
		ClienteRepository repository = new ClienteRepositoryImpl(new DbConfig());
		repository = new ClienteRepositoryMock();
		var srv = new ClienteService(repository);
		srv = new ClienteService(new ClienteRepositoryImpl(new DbConfig()));
		srv.add(cliente);
	}

}
