package com.ceiba.mascota.testdatabuilder;

import com.ceiba.mascota.modelo.entidad.TipoMascota;

public class TipoMascotaTestDataBuilder {
    private long id;
    private String nombre;

    public TipoMascotaTestDataBuilder() {
        this.id = 1L;
        this.nombre = "Tipo mascota 1";
    }

    public TipoMascotaTestDataBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TipoMascotaTestDataBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoMascota build() {
        return new TipoMascota(id, nombre);
    }
}
