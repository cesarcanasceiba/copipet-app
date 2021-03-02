package com.ceiba.ciudad.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.infraestructura.jdbc.MapperResult;

import org.springframework.jdbc.core.RowMapper;

public class MapeoCiudad implements RowMapper<Ciudad>, MapperResult {

    @Override
    public Ciudad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        return new Ciudad(id, nombre);
    }

}
