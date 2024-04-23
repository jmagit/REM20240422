package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.domains.contracts.services.EducadoService;
import com.example.domains.contracts.services.EducadoServiceImpl;
import com.example.infraestructure.repositories.DbConfig;
import com.example.ioc.Cotilla;

@Configuration
public class AppConfig {

	@Bean
	public EducadoService bienEducadoService(DbConfig cfg) {
		return new EducadoServiceImpl("mundo", cfg);
	}
	@Bean
	public EducadoService malEducadoService(DbConfig cfg) {
		return new EducadoServiceImpl("MUNDO", cfg);
	}

	@Bean
	@Qualifier("test")
	public Cotilla cotillaTest() {
		return new Cotilla("Test");
	}
	@Bean
	@Qualifier("prod")
	public Cotilla cotillaProd() {
		return new Cotilla("Prod");
	}
	

	@Bean int version() { return 2; }
	@Bean int errorLevel() { return 0; }
	@Bean() String autor() { return "Yo mismo"; }

}
