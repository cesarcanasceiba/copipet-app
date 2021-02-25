package com.ceiba.producto.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Producto {
    @NonNull Long id;
    @NonNull private String nombre;
    @NonNull private MarcaProducto marca;
    @NonNull private CategoriaProducto categoriaProducto;
    @NonNull private Long precio;
    @NonNull private String presentacion;
    @NonNull private String foto;
    @NonNull private String descripcion;
    @NonNull private String caracteristicas;
    @NonNull private String beneficios;
    @NonNull private String codigoProducto;
}
