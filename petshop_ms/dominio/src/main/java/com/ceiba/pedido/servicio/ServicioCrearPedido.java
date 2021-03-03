package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioCrearPedido {
    private final RepositorioPedido repositorioPedido;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Pedido ejecutar(Pedido pedido) {
        return this.repositorioPedido.crear(pedido);
    }
}
