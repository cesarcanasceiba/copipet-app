package com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.infraestructura.jdbc.MapperResult;

import org.springframework.jdbc.core.RowMapper;

public class MapeoPeluquero implements RowMapper<Peluquero>, MapperResult {

    @Override
    public Peluquero mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        return new Peluquero(id, nombre);
    }

}
