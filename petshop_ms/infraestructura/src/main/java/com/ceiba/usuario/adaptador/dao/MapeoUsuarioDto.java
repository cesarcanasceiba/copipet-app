package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuarioDto implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        Boolean aceptaTerminos = rs.getBoolean("acepta_terminos");
        Long ciudad = rs.getLong("ciudad_id");
        Long tipoMascota = rs.getLong("tipo_mascota_id");

        return new DtoUsuario(id, nombre, direccion, telefono, aceptaTerminos, ciudad, tipoMascota);
    }
}
