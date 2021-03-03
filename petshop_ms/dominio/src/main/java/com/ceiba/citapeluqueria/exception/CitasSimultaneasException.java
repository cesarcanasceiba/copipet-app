package com.ceiba.citapeluqueria.exception;

public class CitasSimultaneasException extends RuntimeException {

	private static final long serialVersionUID = -4585866964244328033L;

	@Override
	public String getMessage() {
		return "No hay mas cupos de citas para asociar en este rango de tiempo";
	}
}
