package com.ceiba.citapeluqueria.adaptador.dao.mysql;

import java.util.List;
import com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo.MapeoServicioPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoServicioPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoServicioPeluqueriaMysql implements DaoServicioPeluqueria {
    @SqlStatement(namespace = "serviciopeluqueria", value = "consultarListadoPorId")
    String consultarListadoPorId;

    @SqlStatement(namespace = "serviciopeluqueria", value = "consultarListadoPorCita")
    String consultarListadoPorCita;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoServicioPeluqueriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<ServicioPeluqueria> encontrarServiciosPorId(List<Long> listaServicios) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("listadoIds", listaServicios);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(consultarListadoPorId,
                params, new MapeoServicioPeluqueria());
    }

    @Override
    public List<ServicioPeluqueria> encontrarServiciosPorCitaPeluqueria(Long citaId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("citaId", citaId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(consultarListadoPorCita,
                params, new MapeoServicioPeluqueria());
    }
}
