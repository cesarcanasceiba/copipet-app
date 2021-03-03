package com.ceiba.error;

import com.ceiba.citapeluqueria.exception.CitasSimultaneasException;
import com.ceiba.citapeluqueria.exception.CiudadNoValidaParaCita;
import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.infraestructura.error.ManejadorError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracionErroresNegocioHandler {

    public ConfiguracionErroresNegocioHandler(ManejadorError manejadorError) {
        manejadorError.registrarExcepcionNegocio(CiudadNoValidaParaCita.class, HttpStatus.BAD_REQUEST);
        manejadorError.registrarExcepcionNegocio(CitasSimultaneasException.class, HttpStatus.BAD_REQUEST);
        manejadorError.registrarExcepcionNegocio(FechaInicioCitaInvalidaException.class, HttpStatus.BAD_REQUEST);
        manejadorError.registrarExcepcionNegocio(PesoNoAceptadoException.class, HttpStatus.BAD_REQUEST);
    }
}
