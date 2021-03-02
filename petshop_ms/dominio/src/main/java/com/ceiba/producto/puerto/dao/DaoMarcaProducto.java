package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.entidad.MarcaProducto;

public interface DaoMarcaProducto {
    MarcaProducto encontrarPorId(Long id);
}
