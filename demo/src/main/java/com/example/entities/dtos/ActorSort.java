package com.example.entities.dtos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.example.entities.Actor;

@Projection(name = "actorAcortado", types = { Actor.class }) 
public interface ActorSort {
	@Value("#{target.ActorId}")
	int getId();
	@Value("#{target.lastName + ', ' + target.firstName}")
	String getNombre();
}
