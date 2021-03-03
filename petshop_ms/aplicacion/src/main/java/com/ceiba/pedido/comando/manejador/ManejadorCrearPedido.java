package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoPedido, Pedido> {
    private FabricaPedido fabricaPedido;
    private ServicioCrearPedido servicioCrearPedido;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, ServicioCrearPedido servicioCrearPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
    }

    public Pedido ejecutar(ComandoPedido comandoPedido) throws PedidoConListasVaciasException,
            PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        return this.servicioCrearPedido.ejecutar(pedido);
    }
}
