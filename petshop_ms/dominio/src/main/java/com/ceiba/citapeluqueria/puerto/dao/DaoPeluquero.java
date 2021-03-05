package com.ceiba.citapeluqueria.puerto.dao;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;

public interface DaoPeluquero {
    Peluquero encontrarPorId(Long id);

    List<Peluquero> lista();
}
