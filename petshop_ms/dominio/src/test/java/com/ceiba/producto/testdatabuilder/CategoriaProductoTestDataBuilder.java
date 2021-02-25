package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.modelo.entidad.CategoriaProducto;

public class CategoriaProductoTestDataBuilder {
	private String nombre;
	private long id;

	public CategoriaProductoTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Categoria producto 1";
	}

	public CategoriaProducto build() {
		return new CategoriaProducto(id, nombre);
	}

	public CategoriaProductoTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CategoriaProductoTestDataBuilder setId(long id) {
		this.id = id;
		return this;
	}
}
