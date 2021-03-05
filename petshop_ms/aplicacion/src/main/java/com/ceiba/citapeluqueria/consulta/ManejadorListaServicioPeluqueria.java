package com.ceiba.citapeluqueria.consulta;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoServicioPeluqueria;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListaServicioPeluqueria {
    private DaoServicioPeluqueria daoServicioPeluqueria;

    public ManejadorListaServicioPeluqueria(DaoServicioPeluqueria daoServicioPeluqueria) {
        this.daoServicioPeluqueria = daoServicioPeluqueria;
    }

    public List<ServicioPeluqueria> ejecutar() {
        return this.daoServicioPeluqueria.lista();
    }
}
