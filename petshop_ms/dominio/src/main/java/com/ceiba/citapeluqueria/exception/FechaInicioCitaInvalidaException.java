package com.ceiba.citapeluqueria.exception;

public class FechaInicioCitaInvalidaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4754164199229645354L;

	@Override
	public String getMessage() {
		return "La fecha de inicio de la cita no puede ser menor a la fecha actual";
	}

}
