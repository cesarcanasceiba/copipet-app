package com.ceiba.producto.consulta;

import java.util.List;

import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.puerto.dao.DaoCategoriaProducto;

import org.springframework.stereotype.Component;

@Component
public class ManejadorListaCategoriaProducto {
    private DaoCategoriaProducto daoCategoria;

    public ManejadorListaCategoriaProducto(DaoCategoriaProducto daoCategoria) {
        this.daoCategoria = daoCategoria;
    }

    public List<CategoriaProducto> ejecutar() {
        return this.daoCategoria.lista();
    }
}
