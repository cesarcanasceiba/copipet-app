package com.ceiba.ciudad.consulta;

import java.util.List;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListaCiudad {
    private DaoCiudad daoCiudad;

    public ManejadorListaCiudad(DaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }

    public List<Ciudad> ejecutar() {
        return this.daoCiudad.lista();
    }
}
