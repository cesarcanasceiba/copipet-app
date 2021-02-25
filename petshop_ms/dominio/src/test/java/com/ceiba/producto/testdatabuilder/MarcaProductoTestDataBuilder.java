package com.ceiba.producto.testdatabuilder;

import com.ceiba.TestDataBuilderInterface;
import com.ceiba.producto.modelo.entidad.MarcaProducto;

public class MarcaProductoTestDataBuilder implements TestDataBuilderInterface<MarcaProducto>{

	private long id;
	private String nombre;

	public MarcaProductoTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Marca producto 1";
	}
	
	public MarcaProductoTestDataBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public MarcaProductoTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public MarcaProducto build() {
		return new MarcaProducto(id, nombre);
	}
}
