package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.domains.contracts.services.ClienteService;
import com.example.domains.contracts.services.EducadoService;
import com.example.entities.Cliente;
import com.example.infraestructure.repositories.ClienteRepositoryImpl;
import com.example.infraestructure.repositories.ClienteRepositoryMock;
import com.example.infraestructure.repositories.DbConfig;
import com.example.ioc.Cotilla;
import com.example.ioc.EjemplosIoC;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ClienteService srv;
	
	@Autowired
	private EducadoService malEducadoService;

	@Autowired
	@Qualifier("prod")
	private Cotilla otro;
	
	@Autowired(required = false)
	@Lazy
	private EjemplosIoC demo;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		
		var cliente = new Cliente();
//		ClienteRepository repository = new ClienteRepositoryImpl(new DbConfig());
//		repository = new ClienteRepositoryMock();
//		var srv = new ClienteService(repository);
//		srv = new ClienteService(new ClienteRepositoryImpl(new DbConfig()));
//		malEducadoService.saluda();
//		srv.add(cliente);
//		malEducadoService.saluda();
//		malEducadoService.despide();
//		//System.out.println(demo == null ? "No lo encuentro" : demo.toString());
//		System.out.println(otro);
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("test");
		ctx.refresh();	
//		var edu = (EducadoService)ctx.getBean("malEducadoService");
//		edu.saluda();
	}

}
