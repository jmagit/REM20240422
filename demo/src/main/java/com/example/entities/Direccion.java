package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Direccion {
	private int id;
	private String calle;
	private int num;
	private String cp;
	private String provincia;
}
