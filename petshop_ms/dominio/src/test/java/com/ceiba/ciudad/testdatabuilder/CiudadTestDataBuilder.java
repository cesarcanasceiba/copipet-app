package com.ceiba.ciudad.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;

public class CiudadTestDataBuilder {
    private long id;
    private String nombre;

    public CiudadTestDataBuilder() {
        this.id = 1L;
        this.nombre = "Ciudad 1";
    }

    public Ciudad build() {
        return new Ciudad(id, nombre);
    }

	public CiudadTestDataBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public CiudadTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
}
