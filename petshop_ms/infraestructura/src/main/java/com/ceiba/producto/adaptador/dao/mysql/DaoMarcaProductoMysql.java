package com.ceiba.producto.adaptador.dao.mysql;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.adaptador.dao.mysql.mapeo.MapeoMarcaProducto;
import com.ceiba.producto.modelo.entidad.MarcaProducto;
import com.ceiba.producto.puerto.dao.DaoMarcaProducto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoMarcaProductoMysql implements DaoMarcaProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "marcaproducto", value = "consultarPorId")
    private static String sqlEncontrarPorId;

    public DaoMarcaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public MarcaProducto encontrarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlEncontrarPorId,
                params, new MapeoMarcaProducto());
    }

}
