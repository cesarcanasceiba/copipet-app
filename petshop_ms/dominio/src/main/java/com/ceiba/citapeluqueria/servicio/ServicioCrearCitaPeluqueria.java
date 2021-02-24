package com.ceiba.citapeluqueria.servicio;

import com.ceiba.citapeluqueria.exception.CitasSimultaneasException;
import com.ceiba.citapeluqueria.exception.CiudadNoValidaParaCita;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.generadorciudad.GeneradorCiudadValidaCitaPeluqueria;
import com.ceiba.ciudad.modelo.entidad.Ciudad;

public class ServicioCrearCitaPeluqueria {
	
	private RepositorioCitaPeluqueria repositorio;
	private GeneradorCiudadValidaCitaPeluqueria ciudadValida;
	
	public ServicioCrearCitaPeluqueria(RepositorioCitaPeluqueria repositorio, GeneradorCiudadValidaCitaPeluqueria ciudadValida) {
		this.repositorio = repositorio;
		this.ciudadValida = ciudadValida;
	}
	public CitaPeluqueria ejecutar(CitaPeluqueria cita, Ciudad ciudad) throws CiudadNoValidaParaCita, CitasSimultaneasException {
        this.validarCiudad(ciudad);
        this.validarSimultaneidadCita();
		return this.repositorio.crear(cita);
    }
	private void validarSimultaneidadCita() throws CitasSimultaneasException {
		if(this.repositorio.existenCitasSimultaneas()) throw new CitasSimultaneasException();
		
	}
	private void validarCiudad(Ciudad ciudad) throws CiudadNoValidaParaCita {
	    Ciudad bogotaCiudad = this.ciudadValida.get();
	    if (!bogotaCiudad.equals(ciudad)) throw new CiudadNoValidaParaCita();
	}
}
