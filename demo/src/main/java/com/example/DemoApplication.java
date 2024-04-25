package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.aop.Visible;
import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.contracts.services.ClienteService;
import com.example.domains.contracts.services.EducadoService;
import com.example.entities.Actor;
import com.example.entities.Cliente;
import com.example.entities.dtos.ActorDTO;
import com.example.entities.dtos.ActorSort;
import com.example.ioc.Cotilla;
import com.example.ioc.EjemplosIoC;
import com.example.ioc.Rango;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	int version() {
		return 222;
	}

	@Bean
	int errorLevel() {
		return 0;
	}

	@Bean()
	String autor() {
		return "Yo mismo";
	}

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

	@Autowired
	private ClienteService srv;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicacion arrancada");
		demosSpringData();
	}

	@Autowired
	ActorRepository dao;

	public void demosSpringData() throws Exception {
//		var a = new Actor("Pepito", "Grillo");
//		dao.save(a);
//		var item = dao.findById(202);
//		if(item.isPresent()) {
//			var a = item.get();
//			a.setFirstName(a.getFirstName().toUpperCase());
//			dao.save(a);
//		} else {
//			System.err.println("No encontrado");
//		}
//		dao.deleteById(202); 
//		dao.findAll().forEach(System.out::println);
//		System.out.println(dao.count());
//		dao.findTop5ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findByActorIdGreaterThanEqual(200).forEach(System.out::println);
//		dao.findConJPA(200).forEach(System.out::println);
//		dao.findConSQL(200).forEach(System.out::println);
//		dao.findAll(PageRequest.of(1, 10)).forEach(System.out::println);
//		dao.findByActorIdGreaterThanEqual(10, PageRequest.of(1, 10)).forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("actorId")).forEach(System.out::println);
//		dao.findConSQL(2, PageRequest.of(5, 10)).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 10))
//			.forEach(System.out::println);
//		var a = new Actor(null, "GG");
//		if (a.isValid()) {
//			dao.save(a);
//		} else {
//			System.err.println(a.getErrorsMessage());
//		}
//		dao.findBy().forEach(System.out::println);
		//dao.findBy().forEach(item -> System.out.println(item.getActorId() + " " + item.getNombre()));
		dao.findBy(ActorDTO.class).forEach(System.out::println);
		dao.findBy(ActorSort.class).forEach(item -> System.out.println(item.getId() + " " + item.getNombre()));
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	static class ActorRowMapper implements RowMapper<Actor> {
		@Override
		public Actor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Actor newActor = new Actor();
			newActor.setFirstName(resultSet.getString("first_name"));
			newActor.setLastName(resultSet.getString("last_name"));
			return newActor;
		}
	}

	public void demosJDBC() throws Exception {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from actor", Integer.class);
		System.out.println(rowCount);
		rowCount = this.jdbcTemplate.queryForObject("select count(*) from actor where first_name = ?", Integer.class,
				"PENELOPE");
		System.out.println(rowCount);
		Actor actor = jdbcTemplate.queryForObject("select first_name, last_name from actor where actor_id = ?",
				(resultSet, rowNum) -> {
					Actor newActor = new Actor();
					newActor.setFirstName(resultSet.getString("first_name"));
					newActor.setLastName(resultSet.getString("last_name"));
					return newActor;
				}, (long) 1);
		System.out.println(actor);
//		jdbcTemplate.update(
//		        "insert into actor (first_name, last_name) values (?, ?)",
//		        "PEPITO", "grillo");
//		jdbcTemplate.update(
//		        "update actor set last_name=? where actor_id = ?",
//		        "GRILLO", 201L);
//		jdbcTemplate.update("delete from actor where actor_id = ?", 1L);

		List<Actor> actors = this.jdbcTemplate.query(
				"select first_name, last_name from actor where first_name like ? LIMIT 3", new ActorRowMapper(), "P%");
		actors.forEach(System.out::println);
	}

	public void demosAOP() throws Exception {
		var cliente = new Cliente();
		cliente.setNombre("Pepito");
		cliente = srv.add(cliente);
		if (srv instanceof Visible)
			System.out.println("Implementa visible");
		((Visible) srv).mostrar();
		System.out.println("Ahora " + (((Visible) srv).isVisible() ? "" : "NO ") + "me ves");
		((Visible) srv).ocultar();
		System.out.println("Ahora " + (((Visible) srv).isVisible() ? "" : "NO ") + "me ves");
		System.out.println(cliente);
//		System.out.println(srv.getClass().getCanonicalName());

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
