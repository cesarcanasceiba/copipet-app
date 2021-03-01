package com.ceiba.producto.consulta;

import java.util.List;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListaProductosResumen {

    private final DaoProducto productoDao;

    public ManejadorListaProductosResumen(DaoProducto productoDao) {
        this.productoDao = productoDao;
    }

    public List<ProductoResumenDTO> ejecutar() {
        return this.productoDao.listaProductosResumen();
    }
}
