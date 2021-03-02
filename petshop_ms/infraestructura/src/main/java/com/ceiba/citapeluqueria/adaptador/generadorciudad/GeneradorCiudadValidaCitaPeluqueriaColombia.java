package com.ceiba.citapeluqueria.adaptador.generadorciudad;

import com.ceiba.citapeluqueria.puerto.generadorciudad.GeneradorCiudadValidaCitaPeluqueria;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;

import org.springframework.stereotype.Component;

@Component
public class GeneradorCiudadValidaCitaPeluqueriaColombia implements GeneradorCiudadValidaCitaPeluqueria {

    private DaoCiudad daoCiudad;

    @Override
    public Ciudad get() {
        return this.daoCiudad.encontrarPorId(1L);
    }

    public GeneradorCiudadValidaCitaPeluqueriaColombia(DaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }
}
