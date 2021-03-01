package com.ceiba.citapeluqueria.comando.fabrica;

import com.ceiba.citapeluqueria.comando.ComandoPeluquero;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;

import org.springframework.stereotype.Component;

@Component
public class FabricaPeluquero {
    public Peluquero crear(ComandoPeluquero comandoPeluquero) {
        return new Peluquero(comandoPeluquero.getId(), comandoPeluquero.getNombre());
    }
}
