package com.ceiba.citapeluqueria.adaptador.dao.mysql;

import java.util.List;

import com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo.MapeoPeluquero;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.citapeluqueria.puerto.dao.DaoPeluquero;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPeluqueroMysql implements DaoPeluquero {

    @SqlStatement(namespace = "peluquero", value = "consultarPorId")
    private static String consultarPorId;

    @SqlStatement(namespace = "peluquero", value = "lista")
    private static String sqlLista;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoPeluqueroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Peluquero encontrarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoPeluquero());
    }

    @Override
    public List<Peluquero> lista() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlLista,
                new MapeoPeluquero());
    }
}
