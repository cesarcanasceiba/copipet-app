package com.ceiba.producto.puerto.dao;

import java.util.List;

import com.ceiba.producto.modelo.entidad.CategoriaProducto;

public interface DaoCategoriaProducto {
    CategoriaProducto encontrarPorId(Long id);

    List<CategoriaProducto> lista();
}
