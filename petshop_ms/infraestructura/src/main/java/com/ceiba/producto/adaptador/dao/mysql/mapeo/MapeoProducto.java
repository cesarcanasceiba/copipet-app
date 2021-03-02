package com.ceiba.producto.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.modelo.entidad.MarcaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoCategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoMarcaProducto;

import org.springframework.jdbc.core.RowMapper;

public class MapeoProducto implements RowMapper<Producto>, MapperResult {

    private DaoCategoriaProducto daoCategoriaProducto;
    private DaoMarcaProducto daoMarcaProducto;

    public MapeoProducto(DaoMarcaProducto daoMarcaProducto, DaoCategoriaProducto daoCategoriaProducto) {
        this.daoMarcaProducto = daoMarcaProducto;
        this.daoCategoriaProducto = daoCategoriaProducto;
    }

    @Override
    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        MarcaProducto marca = this.daoMarcaProducto.encontrarPorId(rs.getLong("marca_id"));
        CategoriaProducto categoriaProducto = this.daoCategoriaProducto.encontrarPorId(rs.getLong("categoria_id"));
        Long precio = rs.getLong("precio");
        String presentacion = rs.getString("presentacion");
        String foto = rs.getString("foto");
        String descripcion = rs.getString("descripcion");
        String caracteristicas = rs.getString("caracteristicas");
        String beneficios = rs.getString("beneficios");
        String codigoProducto = rs.getString("codigoProducto");

        return new Producto(id, nombre, marca, categoriaProducto, precio, presentacion, foto, descripcion,
                caracteristicas, beneficios, codigoProducto);
    }
}
