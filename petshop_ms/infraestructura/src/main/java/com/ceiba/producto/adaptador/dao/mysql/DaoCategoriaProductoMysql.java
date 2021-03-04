package com.ceiba.producto.adaptador.dao.mysql;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.adaptador.dao.mysql.mapeo.MapeoCategoriaProducto;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoCategoriaProducto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoCategoriaProductoMysql implements DaoCategoriaProducto {

    @SqlStatement(namespace = "categoriaproducto", value = "consultarPorId")
    private static String sqlEncontrarPorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoCategoriaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public CategoriaProducto encontrarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEncontrarPorId,
                params, new MapeoCategoriaProducto());
    }

}
