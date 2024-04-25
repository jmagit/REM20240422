package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor")
@Data @NoArgsConstructor
public class Actor extends EntityBase<Actor> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "actor_id")
	@JsonProperty("id")
	private int actorId;	
	@Column(name = "first_name")
	@NotBlank
	@Size(max = 45, min=2)
	@JsonProperty("nombre")
	private String firstName;
	@NotBlank
	@Size(max = 45, min=2)
	@Pattern(regexp = "^[A-Z]+$", message = "debe estar en mayusculas")
	@Column(name = "last_name")
	@JsonProperty("apellidos")
	private String lastName;
	@Column(name = "last_update", insertable=false, updatable=false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonIgnore
	private Date lastUpdate;
	
	public Actor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
