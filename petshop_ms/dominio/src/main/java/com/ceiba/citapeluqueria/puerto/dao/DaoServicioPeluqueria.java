package com.ceiba.citapeluqueria.puerto.dao;

import java.util.List;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;

public interface DaoServicioPeluqueria {
    List<ServicioPeluqueria> encontrarServiciosPorId(List<Long> listaServicios);

    List<ServicioPeluqueria> encontrarServiciosPorCitaPeluqueria(Long citaId);
}
