package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorProductoDetalle {
    private final DaoProducto productoDao;

    public ManejadorProductoDetalle(DaoProducto productoDao) {
        this.productoDao = productoDao;
    }

    public ProductoDetalleDTO ejecutar(Long id) {
        return this.productoDao.verDetalleProducto(id);
    }
}
