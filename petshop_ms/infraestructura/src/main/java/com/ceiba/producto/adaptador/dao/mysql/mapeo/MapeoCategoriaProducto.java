package com.ceiba.producto.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;

import org.springframework.jdbc.core.RowMapper;

public class MapeoCategoriaProducto implements RowMapper<CategoriaProducto>, MapperResult {

    @Override
    public CategoriaProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        return new CategoriaProducto(id, nombre);
    }

}
