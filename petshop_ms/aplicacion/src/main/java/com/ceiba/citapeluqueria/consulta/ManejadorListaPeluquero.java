package com.ceiba.citapeluqueria.consulta;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.citapeluqueria.puerto.dao.DaoPeluquero;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListaPeluquero {
    private DaoPeluquero daoPeluquero;

    public ManejadorListaPeluquero(DaoPeluquero daoPeluquero) {
        this.daoPeluquero = daoPeluquero;
    }

    public List<Peluquero> ejecutar() {
        return this.daoPeluquero.lista();
    }
}
