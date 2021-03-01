package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.entidad.CategoriaProducto;

public interface DaoCategoriaProducto {
    CategoriaProducto encontrarPorId(Long id);
}
