package com.ceiba.citapeluqueria.modelo.entidad;

import java.util.Date;
import java.util.List;
import lombok.*;

import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Getter
public class CitaPeluqueria {
    private Long id;
    private Peluquero peluquero;
    private List<ServicioPeluqueria> servicios;
    private Date horaInicio;
    private Date horaFinal;
    private Usuario usuario;
    private String fotoMascota;
    private Integer pesoMascota;
    private Integer costoCita;
	
    public CitaPeluqueria(Peluquero peluquero, List<ServicioPeluqueria> servicios, Date horaInicio, Date horaFinal,
			Usuario usuario, String fotoMascota, Integer pesoMascota) {
		super();
		this.peluquero = peluquero;
		this.servicios = servicios;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.usuario = usuario;
		this.fotoMascota = fotoMascota;
		this.pesoMascota = pesoMascota;
	}
    
    public Long calcularPrecio() throws PesoNoAceptadoException {
    	if(isBetween(this.pesoMascota, 2, 4.5)) {
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
    
    private boolean isBetween(int x, double lower, double upper) {
    	  return lower <= x && x <= upper;
    }
    
    
}
