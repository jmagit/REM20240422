package com.example.ioc;

import java.beans.ConstructorProperties;

import org.springframework.stereotype.Component;

@Component
public class EjemplosIoC {
	@ConstructorProperties({"version", "autor"})
	public EjemplosIoC(int version, String autor) {
		System.out.println(">>>>>Entero: " + version);
	}
	public void carga() {
		System.out.println("carga");
	}
}
