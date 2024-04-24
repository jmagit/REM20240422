package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class DefaultVisible implements Visible {
	private int count = 0;

	@Override
	public void mostrar() {
		count++;
	}

	@Override
	public void ocultar() {
		count = count > 0 ? (count - 1) : 0;
	}

	@Override
	public boolean isVisible() {
		return count > 0;
	}
}
