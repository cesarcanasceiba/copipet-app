package com.ceiba.mascota.consulta;

import java.util.List;

import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.mascota.puerto.dao.DaoTipoMascota;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListaTipoMascota {
    private DaoTipoMascota daoTipoMascota;

    public ManejadorListaTipoMascota(DaoTipoMascota daoTipoMascota) {
        this.daoTipoMascota = daoTipoMascota;
    }

    public List<TipoMascota> ejecutar() {
        return this.daoTipoMascota.listar();
    }
}
