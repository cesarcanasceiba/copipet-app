package com.ceiba.pedido.puerto.repositorio;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioPedido {
    Pedido crear(Pedido pedido);

    Boolean asociarCitasAPedidos(Pedido pedido, List<CitaPeluqueria> citas);

    Boolean asociarProductosAPedidos(Pedido pedido, List<Producto> productos);
}
