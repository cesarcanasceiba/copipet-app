package com.ceiba.citapeluqueria.exception;

public class CiudadNoValidaParaCita extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -6052426809811733436L;

	@Override
	public String getMessage() {
		return "La ciudad seleccionada no es válida para agendar cita de peluquería";
	}

}
