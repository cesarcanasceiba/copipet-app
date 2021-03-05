package com.ceiba.pedido.comando.manejador;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
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
    private DaoCiudad daoCiudad;

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, ServicioCrearPedido servicioCrearPedido,
            DaoCiudad daoCiudad) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
        this.daoCiudad = daoCiudad;
    }

    public Pedido ejecutar(ComandoPedido comandoPedido) throws PedidoConListasVaciasException,
            PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
        Ciudad ciudad = null;
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        if (comandoPedido.getCitasPeluqueria().size() > 0) {
            Long ciudadId = comandoPedido.getCitasPeluqueria().get(0).getCiudad();
            ciudad = this.daoCiudad.encontrarPorId(ciudadId);
        }

        return this.servicioCrearPedido.ejecutar(pedido, ciudad);
    }
}
