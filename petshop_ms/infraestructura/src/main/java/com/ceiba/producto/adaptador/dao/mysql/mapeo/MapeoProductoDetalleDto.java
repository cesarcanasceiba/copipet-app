package com.ceiba.producto.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import org.springframework.jdbc.core.RowMapper;

public class MapeoProductoDetalleDto implements RowMapper<ProductoDetalleDTO>, MapperResult {

    @Override
    public ProductoDetalleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String marca = rs.getString("marca");
        Long precio = rs.getLong("precio");
        String presentacion = rs.getString("presentacion");
        String foto = rs.getString("foto");
        String descripcion = rs.getString("descripcion");
        String caracteristicas = rs.getString("caracteristicas");
        String beneficios = rs.getString("beneficios");
        String codigoProducto = rs.getString("codigo_producto");
        String categoriaProducto = rs.getString("categoria_producto");
        return new ProductoDetalleDTO(id, nombre, marca, precio, presentacion, foto, descripcion, caracteristicas,
                beneficios, codigoProducto, categoriaProducto);
    }

}
