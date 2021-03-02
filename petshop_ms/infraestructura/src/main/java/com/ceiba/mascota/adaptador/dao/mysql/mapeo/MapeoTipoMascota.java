package com.ceiba.mascota.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.mascota.modelo.entidad.TipoMascota;

import org.springframework.jdbc.core.RowMapper;

public class MapeoTipoMascota implements RowMapper<TipoMascota>, MapperResult {

    @Override
    public TipoMascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        return new TipoMascota(id, nombre);
    }

}