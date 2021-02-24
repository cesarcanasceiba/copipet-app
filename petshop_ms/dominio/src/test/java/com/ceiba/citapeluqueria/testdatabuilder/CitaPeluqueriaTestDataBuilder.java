package com.ceiba.citapeluqueria.testdatabuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class CitaPeluqueriaTestDataBuilder {
	private Long id;
    private Peluquero peluquero;
    private List<ServicioPeluqueria> servicios;
    private Date fechaInicio;
    private Date fechaFinal;
    private Usuario usuario;
    private String fotoMascota;
    private Float pesoMascota;
    

    public CitaPeluqueriaTestDataBuilder() {
        this.peluquero = Mockito.mock(Peluquero.class);
		this.servicios = new ArrayList<>();
		ServicioPeluqueria servicio = Mockito.mock(ServicioPeluqueria.class);
		this.servicios.add(servicio);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        this.fechaInicio = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        this.fechaFinal = calendar.getTime();

        this.usuario = Mockito.mock(Usuario.class);
        this.fotoMascota = "";
        this.pesoMascota = 35F;
    }

	public CitaPeluqueriaTestDataBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setPeluquero(Peluquero peluquero) {
		this.peluquero = peluquero;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setServicios(List<ServicioPeluqueria> servicios) {
		this.servicios = servicios;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setFotoMascota(String fotoMascota) {
		this.fotoMascota = fotoMascota;
		return this;
	}

	public CitaPeluqueriaTestDataBuilder setPesoMascota(Float pesoMascota) {
		this.pesoMascota = pesoMascota;
		return this;
	}

	public CitaPeluqueria build() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		return new CitaPeluqueria(peluquero, servicios, fechaInicio, usuario, fotoMascota, pesoMascota);
	}
}
