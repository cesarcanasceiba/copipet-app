package com.ceiba.pedido.adaptador.dao.mysql;

import com.ceiba.citapeluqueria.puerto.dao.DaoCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.adaptador.dao.mysql.mapeo.MapeoPedido;
import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoBonoDescuento;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPedidoMysql implements DaoPedido {

    @SqlStatement(namespace = "pedido", value = "consultarPorId")
    private static String consultarPorId;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoBonoDescuento daoBonoDescuento;
    private ConversorMonedaInterface conversorMoneda;
    private DaoProducto daoProducto;
    private DaoCitaPeluqueria daoCitaPeluqueria;

    public DaoPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoBonoDescuento daoBonoDescuento, DaoProducto daoProducto, DaoCitaPeluqueria daoCitaPeluqueria,
            ConversorMonedaInterface conversorMoneda) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoBonoDescuento = daoBonoDescuento;
        this.daoProducto = daoProducto;
        this.conversorMoneda = conversorMoneda;
        this.daoCitaPeluqueria = daoCitaPeluqueria;
    }

    @Override
    public Pedido obtenerPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoPedido(daoProducto, daoCitaPeluqueria, daoBonoDescuento, conversorMoneda));
    }

}
