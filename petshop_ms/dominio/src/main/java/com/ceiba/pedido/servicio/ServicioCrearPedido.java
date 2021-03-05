package com.ceiba.pedido.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.ServicioCrearCitaPeluqueria;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioCrearPedido {
    private final RepositorioPedido repositorioPedido;
    private final ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido,
            ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria) {
        this.repositorioPedido = repositorioPedido;
        this.servicioCrearCitaPeluqueria = servicioCrearCitaPeluqueria;
    }

    public Pedido ejecutar(Pedido pedido, Ciudad ciudadCita) {
        List<CitaPeluqueria> citas = new ArrayList<>();

        Pedido nuevoPedido = this.repositorioPedido.crear(pedido);

        if (pedido.getCitasPeluqueria().size() > 0) {
            citas = pedido.getCitasPeluqueria().stream()
                    .peek(cita -> this.servicioCrearCitaPeluqueria.ejecutar(cita, ciudadCita))
                    .collect(Collectors.toList());
            this.repositorioPedido.asociarCitasAPedidos(nuevoPedido, citas);
        }
        if (pedido.getProductos().size() > 0) {
            this.repositorioPedido.asociarProductosAPedidos(nuevoPedido, pedido.getProductos());
        }
        return nuevoPedido;
    }
}
