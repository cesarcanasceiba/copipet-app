package com.ceiba.pedido.adaptador.repositorio.mysql;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.producto.modelo.entidad.Producto;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RepositorioPedidoMysql implements RepositorioPedido {

        @SqlStatement(namespace = "pedido", value = "crear")
        private static String sqlCrear;

        @SqlStatement(namespace = "pedido", value = "asociarCitasAPedido")
        private static String sqlAsociarCitasAPedidos;

        @SqlStatement(namespace = "pedido", value = "asociarProductosAPedido")
        private static String sqlAsociarProductosAPedidos;

        private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
        private final RepositorioCitaPeluqueria repositorioCitaPeluqueria;

        @Override
        public Pedido crear(Pedido pedido) {
                MapeoInsertarPedidoMysql pedidoInsertar = new MapeoInsertarPedidoMysql(pedido.getCostoTotal(),
                                pedido.getBonoDescuento().getId(), pedido.getFechaEntrega());
                Long nuevoPedidoId = this.customNamedParameterJdbcTemplate.crear(pedidoInsertar, sqlCrear);
                return new Pedido(nuevoPedidoId, pedido.getProductos(), pedido.getCitasPeluqueria(),
                                pedido.getBonoDescuento(), pedido.getFechaEntrega(), pedido.getTipoMoneda(),
                                pedido.getConversorMoneda());
        }

        @Override
        public Boolean asociarCitasAPedidos(Pedido pedido, List<CitaPeluqueria> citas) {
                Stream<CitaPeluqueria> citasNoCreadas = citas.stream().filter(cita -> Objects.isNull(cita.getId()))
                                .map(cita -> RepositorioPedidoMysql.this.repositorioCitaPeluqueria.crear(cita));
                Stream<CitaPeluqueria> citasCreadas = citas.stream().filter(cita -> Objects.nonNull(cita.getId()));
                Stream.concat(citasCreadas, citasNoCreadas)
                                .map(cita -> new MapeoInsertarAsociacionCitaPedidoMysql(pedido.getId(), cita.getId()))
                                .peek(asociacion -> RepositorioPedidoMysql.this.customNamedParameterJdbcTemplate
                                                .crear(asociacion, sqlAsociarCitasAPedidos))
                                .toArray();
                return true;
        }

        @Override
        public Boolean asociarProductosAPedidos(Pedido pedido, List<Producto> productos) {
                productos.stream().map(Producto::getId)
                                .map(pId -> new MapeoInsertarAsociacionProductoPedidoMysql(pedido.getId(), pId))
                                .map(asociacion -> RepositorioPedidoMysql.this.customNamedParameterJdbcTemplate
                                                .crear(asociacion, sqlAsociarProductosAPedidos))
                                .toArray();
                return true;
        }
}
