package com.ceiba.mascota.puerto.dao;

import com.ceiba.mascota.modelo.entidad.TipoMascota;

public interface DaoTipoMascota {
    TipoMascota encontrarMascotaPorId(Long id);
}
