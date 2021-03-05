package com.ceiba.mascota.puerto.dao;

import java.util.List;

import com.ceiba.mascota.modelo.entidad.TipoMascota;

public interface DaoTipoMascota {
    TipoMascota encontrarMascotaPorId(Long id);

    List<TipoMascota> listar();
}
