package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ProductoResumenDTO {
	private Long id;
	private String nombre;
	private String marca;
	private Long precio;
	private String presentacion;
	private String foto;

}
