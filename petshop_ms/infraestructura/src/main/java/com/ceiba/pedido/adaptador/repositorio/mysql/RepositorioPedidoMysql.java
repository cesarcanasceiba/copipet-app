package com.ceiba.pedido.adaptador.repositorio.mysql;

import java.util.Objects;
import java.util.stream.Stream;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.producto.modelo.entidad.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidoMysql implements RepositorioPedido {

    @SqlStatement(namespace = "pedido", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pedido", value = "asociarCitasAPedido")
    private static String sqlAsociarCitasAPedidos;

    @SqlStatement(namespace = "pedido", value = "asociarProductosAPedido")
    private static String sqlAsociarProductosAPedidos;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoPedido daoPedido;

    @Autowired
    RepositorioCitaPeluqueria repositorioCitaPeluqueria;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoPedido daoPedido) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoPedido = daoPedido;
    }

    @Override
    public Pedido crear(Pedido pedido) {
        MapeoInsertarPedidoMysql pedidoInsertar = new MapeoInsertarPedidoMysql(pedido.getCostoTotal(),
                pedido.getBonoDescuento().getId(), pedido.getFechaEntrega());
        Long nuevoPedidoId = this.customNamedParameterJdbcTemplate.crear(pedidoInsertar, sqlCrear);
        Stream<CitaPeluqueria> citasNoCreadas = pedido.getCitasPeluqueria().stream()
                .filter(cita -> Objects.isNull(cita.getId()))
                .map(cita -> RepositorioPedidoMysql.this.repositorioCitaPeluqueria.crear(cita));
        Stream<CitaPeluqueria> citasCreadas = pedido.getCitasPeluqueria().stream()
                .filter(cita -> Objects.nonNull(cita.getId()));
        Stream.concat(citasCreadas, citasNoCreadas)
                .map(cita -> new MapeoInsertarAsociacionCitaPedidoMysql(nuevoPedidoId, cita.getId()))
                .peek(asociacion -> RepositorioPedidoMysql.this.customNamedParameterJdbcTemplate.crear(asociacion,
                        sqlAsociarCitasAPedidos))
                .toArray();
        pedido.getProductos().stream().map(Producto::getId)
                .map(pId -> new MapeoInsertarAsociacionProductoPedidoMysql(nuevoPedidoId, pId))
                .map(asociacion -> RepositorioPedidoMysql.this.customNamedParameterJdbcTemplate.crear(asociacion,
                        sqlAsociarProductosAPedidos))
                .toArray();
        return daoPedido.obtenerPorId(nuevoPedidoId);
    }
}
