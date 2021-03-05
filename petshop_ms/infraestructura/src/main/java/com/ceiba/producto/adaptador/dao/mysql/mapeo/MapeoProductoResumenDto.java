package com.ceiba.producto.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;

import org.springframework.jdbc.core.RowMapper;

public class MapeoProductoResumenDto implements RowMapper<ProductoResumenDTO>, MapperResult {

    @Override
    public ProductoResumenDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String marca = rs.getString("marca");
        Long precio = rs.getLong("precio");
        String presentacion = rs.getString("presentacion");
        String foto = rs.getString("foto");
        return new ProductoResumenDTO(id, nombre, marca, precio, presentacion, foto);
    }
}
