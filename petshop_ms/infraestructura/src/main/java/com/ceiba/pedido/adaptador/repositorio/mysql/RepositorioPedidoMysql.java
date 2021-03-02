package com.ceiba.pedido.adaptador.repositorio.mysql;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidoMysql implements RepositorioPedido {

    @SqlStatement(namespace = "pedido", value = "crear")
    private static String sqlCrear;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoPedido daoPedido;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoPedido daoPedido) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoPedido = daoPedido;
    }

    @Override
    public Pedido crear(Pedido pedido) {
        Long newPedidoId = this.customNamedParameterJdbcTemplate.crear(pedido, sqlCrear);
        return daoPedido.obtenerPorId(newPedidoId);
    }
}
