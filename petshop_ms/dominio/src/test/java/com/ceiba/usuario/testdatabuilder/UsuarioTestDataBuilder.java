package com.ceiba.usuario.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.mascota.testdatabuilder.TipoMascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.exception.UsuarioNoAceptaTerminosException;

public class UsuarioTestDataBuilder {

    private String nombreUsuario;
    private String clave;
    private Ciudad ciudad;
    private TipoMascota tipoMascota;
    private String direccion;
    private String telefono;
    private boolean aceptaTerminos;
    private long id;

    public UsuarioTestDataBuilder() {
        this.id = 1L;
        nombreUsuario = "1234";
        clave = "1234";
        this.direccion = "Dir base";
        this.telefono = "132312";
        this.aceptaTerminos = true;
        this.ciudad = new CiudadTestDataBuilder().build();
        this.tipoMascota = new TipoMascotaTestDataBuilder().build();
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public UsuarioTestDataBuilder conAceptaTerminos(boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
        return this;
    }

    public Usuario build() throws UsuarioNoAceptaTerminosException {
        return new Usuario(id, nombreUsuario, ciudad, tipoMascota, clave, direccion, telefono, aceptaTerminos);
    }
}
