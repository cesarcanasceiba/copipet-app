package com.ceiba.ciudad.adaptador.dao.mysql;

import java.util.List;

import com.ceiba.ciudad.adaptador.dao.mysql.mapeo.MapeoCiudad;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoCiudadMysql implements DaoCiudad {

    @SqlStatement(namespace = "ciudad", value = "consultarPorId")
    private static String consultarPorId;

    @SqlStatement(namespace = "ciudad", value = "lista")
    private static String sqlLista;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoCiudadMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Ciudad encontrarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoCiudad());
    }

    @Override
    public List<Ciudad> lista() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlLista, new MapeoCiudad());
    }
}
