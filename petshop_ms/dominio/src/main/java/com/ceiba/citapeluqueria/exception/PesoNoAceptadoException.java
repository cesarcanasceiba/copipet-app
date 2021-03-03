package com.ceiba.citapeluqueria.exception;

public class PesoNoAceptadoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7325770152673673125L;

	@Override
	public String getMessage() {
		return "El peso de la mascota está fuera de los rangos permitidos";
	}

}
