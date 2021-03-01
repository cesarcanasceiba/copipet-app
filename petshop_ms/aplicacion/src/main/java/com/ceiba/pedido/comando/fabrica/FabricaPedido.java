package com.ceiba.pedido.comando.fabrica;

import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.citapeluqueria.comando.fabrica.FabricaCitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.currency.TipoMoneda;
import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoBonoDescuento;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;

import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {
    private DaoProducto daoProducto;
    private FabricaCitaPeluqueria fabricaCitaPeluqueria;
    private DaoBonoDescuento daoBonoDescuento;
    private ConversorMonedaInterface conversorMonedaInterface;

    public FabricaPedido(DaoProducto daoProducto, FabricaCitaPeluqueria fabricaCitaPeluqueria,
            DaoBonoDescuento daoBonoDescuento, ConversorMonedaInterface conversorMonedaInterface) {
        this.daoProducto = daoProducto;
        this.fabricaCitaPeluqueria = fabricaCitaPeluqueria;
        this.daoBonoDescuento = daoBonoDescuento;
        this.conversorMonedaInterface = conversorMonedaInterface;
    }

    public Pedido crear(ComandoPedido comandoPedido) throws PedidoConListasVaciasException, PedidoSinElementosException,
            FechaDePedidoInvalidaException, ConverterNoImplementadoException {

        List<Producto> productos = daoProducto.listaDeProductosPorId(comandoPedido.getProductos());
        List<CitaPeluqueria> citasPeluqueria = comandoPedido.getCitasPeluqueria().stream()
                .map(this.fabricaCitaPeluqueria::crear).collect(Collectors.toList());
        BonoDescuento bonoDescuento = this.daoBonoDescuento.obtenerBonoPorId(comandoPedido.getBonoDescuento());
        TipoMoneda tipoMoneda = TipoMoneda.valueOf(comandoPedido.getTipoMoneda());
        return new Pedido(comandoPedido.getId(), productos, citasPeluqueria, bonoDescuento,
                comandoPedido.getFechaEntrega(), tipoMoneda, conversorMonedaInterface);
    }
}
