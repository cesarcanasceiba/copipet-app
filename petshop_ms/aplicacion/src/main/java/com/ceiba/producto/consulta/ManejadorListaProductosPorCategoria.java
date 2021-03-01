package com.ceiba.producto.consulta;

import java.util.List;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoCategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListaProductosPorCategoria {
    private DaoProducto productoDao;
    private DaoCategoriaProducto daoCategoriaProducto;

    public ManejadorListaProductosPorCategoria(DaoProducto dao, DaoCategoriaProducto daoCategoriaProducto) {
        this.daoCategoriaProducto = daoCategoriaProducto;
        this.productoDao = dao;
    }

    public List<ProductoResumenDTO> ejecutar(Long comandoCategoriaId) {
        CategoriaProducto categoria = this.daoCategoriaProducto.encontrarPorId(comandoCategoriaId);
        return this.productoDao.listaProductosPorCategoria(categoria);
    }
}
