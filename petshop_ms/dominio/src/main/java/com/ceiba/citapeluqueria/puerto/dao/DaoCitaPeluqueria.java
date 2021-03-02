package com.ceiba.citapeluqueria.puerto.dao;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;

public interface DaoCitaPeluqueria {
    CitaPeluqueria consultarPorId(Long id);

    List<CitaPeluqueria> consultarPorPedido(Long pedidoId);
}
