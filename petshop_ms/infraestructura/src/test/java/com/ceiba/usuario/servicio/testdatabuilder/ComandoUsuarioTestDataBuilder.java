package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private Long ciudad;
    private Long tipoMascota;
    private String password;
    private String direccion;
    private String telefono;
    private boolean aceptaTerminos;

    public ComandoUsuarioTestDataBuilder() {
        id = null;
        nombre = "nombre 1";
        ciudad = 1L;
        tipoMascota = 2L;
        direccion = "dir 1";
        telefono = "tel 1";
        aceptaTerminos = true;

    }

    public ComandoUsuarioTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setCiudad(Long ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setTipoMascota(Long tipoMascota) {
        this.tipoMascota = tipoMascota;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ComandoUsuarioTestDataBuilder setAceptaTerminos(boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id, nombre, ciudad, tipoMascota, password, direccion, telefono, aceptaTerminos);
    }
}
