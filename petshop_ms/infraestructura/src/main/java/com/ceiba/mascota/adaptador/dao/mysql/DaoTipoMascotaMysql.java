package com.ceiba.mascota.adaptador.dao.mysql;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.adaptador.dao.mysql.mapeo.MapeoTipoMascota;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.mascota.puerto.dao.DaoTipoMascota;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoTipoMascotaMysql implements DaoTipoMascota {

    @SqlStatement(namespace = "tipomascota", value = "consultarPorId")
    private static String consultarPorId;

    @SqlStatement(namespace = "tipomascota", value = "lista")
    private static String sqlLista;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoTipoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public TipoMascota encontrarMascotaPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoTipoMascota());
    }

    @Override
    public List<TipoMascota> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlLista,
                new MapeoTipoMascota());
    }

}
