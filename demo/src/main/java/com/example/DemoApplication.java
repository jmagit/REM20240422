package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.example.domains.contracts.repositories.ClienteRepository;
import com.example.domains.contracts.services.ClienteService;
import com.example.domains.contracts.services.EducadoService;
import com.example.entities.Cliente;
import com.example.infraestructure.repositories.ClienteRepositoryImpl;
import com.example.infraestructure.repositories.ClienteRepositoryMock;
import com.example.infraestructure.repositories.DbConfig;
import com.example.ioc.Cotilla;
import com.example.ioc.EjemplosIoC;
import com.example.ioc.Rango;

import jakarta.el.Expression;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean int version() { return 222; }
	@Bean int errorLevel() { return 0; }
	@Bean() String autor() { return "Yo mismo"; }

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

	@Value("------> ${mi.valor:Sin valor}")
	String miValor;
	@Value("${mi.numero}")
	int miNum;

	@Value("#{'${spring.application.name}'.toUpperCase()}")
	String nombre;
	
	@Autowired
	private Rango rango;
	
	@Autowired 
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		demosAOP();
	}
	
	public void demosAOP() throws Exception {
		var cliente = new Cliente();
		srv.add(cliente);
	
	}
	public void demosIoC() throws Exception {
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
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.getEnvironment().setActiveProfiles("test");
//		ctx.refresh();	
//		var ejem = (EjemplosIoC)ctx.getBean(EjemplosIoC.class);
//		ejem.carga();
		System.out.println(nombre);
//		System.out.println(miValor);
//		System.out.println(miNum * 2);
//		System.out.println(rango);
//		System.out.println(env.getProperty("mi.valor"));
//		System.out.println(env.getProperty("spring.application.name"));
//		System.out.println(env.getProperty("rango.min"));
//		ExpressionParser parser = new SpelExpressionParser();
//		String cad = null; 
////		if(cad != null && cad.substring(3) != null && cad.substring(3).toUpperCase() == cad.substring(3)) {
////			
////		}
////		cad = cad?.substring(3)?.length();
//		System.out.println(parser.parseExpression("cad != null ? cad : 'Hello World'").getValue());
//		System.out.println(parser.parseExpression("cad ?: 'Hello World'").getValue());
	}

}
