package com.example.entities.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class ActorDTO {
	private int actorId;	
	private String firstName;
	private String lastName;
}
