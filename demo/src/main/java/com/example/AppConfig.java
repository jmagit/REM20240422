package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
	
//	@Bean
//	DataSource dataSource(Environment env) {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/sakila");
//		ds.setUsername("root");
//		ds.setPassword("root");
//		return ds;
//	}
//
//	@Bean
//	JdbcTemplate jdbcTemplate(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
//
//	@Bean
//	DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}

}
