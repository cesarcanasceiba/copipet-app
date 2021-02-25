package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class ProductoDetalleDTO {
	@NonNull private Long id;
	@NonNull private  String nombre;
	@NonNull private  String marca;
	@NonNull private  Long precio;
	@NonNull private  String presentacion;
	@NonNull private  String foto;
	@NonNull private  String descripcion;
	@NonNull private  String caracteristicas;
	@NonNull private  String beneficios;
	@NonNull private  String codigoProducto;
	@NonNull private  String categoriaProducto;
}
