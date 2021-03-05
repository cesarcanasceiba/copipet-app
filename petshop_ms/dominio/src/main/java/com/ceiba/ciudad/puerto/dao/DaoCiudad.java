package com.ceiba.ciudad.puerto.dao;

import java.util.List;

import com.ceiba.ciudad.modelo.entidad.Ciudad;

public interface DaoCiudad {
    Ciudad encontrarPorId(Long id);

    List<Ciudad> lista();
}
