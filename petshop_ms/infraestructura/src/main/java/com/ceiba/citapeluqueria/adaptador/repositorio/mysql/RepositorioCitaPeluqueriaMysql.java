package com.ceiba.citapeluqueria.adaptador.repositorio.mysql;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCitaPeluqueriaMysql implements RepositorioCitaPeluqueria {

    @SqlStatement(namespace = "citapeluqueria", value = "crear")
    String crearCita;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoCitaPeluqueria daoCitaPeluqueria;

    public RepositorioCitaPeluqueriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoCitaPeluqueria daoCitaPeluqueria) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoCitaPeluqueria = daoCitaPeluqueria;
    }

    @Override
    public CitaPeluqueria crear(CitaPeluqueria citaPeluqueria) {
        Long newUserId = this.customNamedParameterJdbcTemplate.crear(citaPeluqueria, crearCita);
        return daoCitaPeluqueria.consultarPorId(newUserId);
    }

    @Override
    public boolean existenCitasSimultaneas() {
        // TODO Auto-generated method stub
        return false;
    }

}
