package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

@Getter
public class Producto {
    private Long id;
    private String nombre;
    private MarcaProducto marca;
    private CategoriaProducto categoriaProducto;
    private Long precio;
    private String presentacion;
    private String foto;
    private String descripcion;
    private String caracteristicas;
    private String beneficios;
    private String codigoProducto;
}
