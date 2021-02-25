package com.ceiba.citapeluqueria.modelo.entidad;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.*;

import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Getter
public class CitaPeluqueria {
    private Long id;
    private Peluquero peluquero;
    private List<ServicioPeluqueria> servicios;
    private Date fechaInicio;
    private Date fechaFinal;
    private Usuario usuario;
    private String fotoMascota;
    private Float pesoMascota;
    private Long costoCita;

    public CitaPeluqueria(@NonNull Long id, @NonNull Peluquero peluquero, @NonNull List<ServicioPeluqueria> servicios, @NonNull Date fechaInicio,
    		@NonNull Usuario usuario, @NonNull String fotoMascota, @NonNull Float pesoMascota
    		) throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {

    	this.validarFechaInicio(fechaInicio);
    	this.id = id;
		this.peluquero = peluquero;
		this.servicios = Collections.unmodifiableList(servicios);
		this.fechaInicio = new Date(fechaInicio.getTime());
		this.fechaFinal = this.estimarFechaFinal(fechaInicio, pesoMascota);
		this.usuario = usuario;
		this.fotoMascota = fotoMascota;
		this.pesoMascota = pesoMascota;
		this.costoCita = this.calcularPrecio();
	}
    
    public Date getFechaInicio() {
    	return new Date(this.fechaInicio.getTime());
    }

	private void validarFechaInicio(Date fechaInicio) throws FechaInicioCitaInvalidaException {
		if(fechaInicio.compareTo(new Date()) < 0) throw new FechaInicioCitaInvalidaException();
	}



	public Long calcularPrecio() throws PesoNoAceptadoException {
    	if(this.pesoMascota == 2 || isBetween(this.pesoMascota, 2, 4.5)) {
    		return 35000L;
    	}else if(isBetween(this.pesoMascota, 4.5, 10)) {
    		return 50000L;
    	}else if(isBetween(this.pesoMascota, 10, 20)) {
    		return 65000L;
    	}else if(isBetween(this.pesoMascota, 20, 40)) {
    		return 90000L;
    	}else if(isBetween(this.pesoMascota, 40, 55)) {
    		return 120000L;
    	}else {
   		    throw new PesoNoAceptadoException();
    	}
    }
    
    private boolean isBetween(float x, double lower, double upper) {
    	  return lower < x && x <= upper;
    }

    public Date estimarFechaFinal(Date fechaInicio, Float peso) throws PesoNoAceptadoException {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(fechaInicio);
    	if(peso == 2 || isBetween(peso, 2, 4.5)) {
    		calendar.add(Calendar.MINUTE, 30);
    	}else if(isBetween(peso, 4.5, 10)) {
    		calendar.add(Calendar.MINUTE, 45);
    	}else if(isBetween(peso, 10, 20)) {
    		calendar.add(Calendar.MINUTE, 60);
    	}else if(isBetween(peso, 20, 40)) {
    		calendar.add(Calendar.MINUTE, 90);
    	}else if(isBetween(peso, 40, 55)) {
    		calendar.add(Calendar.MINUTE, 120);
    	}else {
   		    throw new PesoNoAceptadoException();
    	}
    	return calendar.getTime();
    }
}
