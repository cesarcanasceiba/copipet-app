package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductoDetalleDTO {
    private Long id;
    private String nombre;
    private String marca;
    private Long Precio;
    private String presentacion;
    private String foto;
    private String descripcion;
    private String caracteristicas;
    private String beneficios;
    private String codigoProducto;
    private String categoriaProducto;
}
