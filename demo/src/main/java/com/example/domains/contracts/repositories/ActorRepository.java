package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.entities.Actor;
import com.example.entities.dtos.ActorDTO;
import com.example.entities.dtos.ActorSort;

@RepositoryRestResource(path="actores", itemResourceRel="actor", collectionResourceRel="actores")
public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
//	List<Actor> findTop5ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
//	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orderBy);
	@RestResource(path = "ultimos")
	List<Actor> findByActorIdGreaterThanEqual(int id);
//	Page<Actor> findByActorIdGreaterThanEqual(int id, Pageable page);
//	@Query("FROM Actor a where a.actorId >= ?1")
//	List<Actor> findConJPA(int id);
//	@Query(value = "select * from actor a where a.actor_id >= :id", nativeQuery = true)
//	List<Actor> findConSQL(int id);
//	@Query(value = "select * from actor a where a.actor_id >= :id", nativeQuery = true)
//	Page<Actor> findConSQL(int id, Pageable page);
	List<ActorSort> findBy();
	@RestResource(exported = false)
	<T> List<T> findBy(Class<T> type);
}
