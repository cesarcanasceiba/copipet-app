package com.ceiba.usuario.modelo.entidad;

import lombok.*;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.usuario.servicio.exception.UsuarioNoAceptaTerminosException;

@Getter
public class Usuario {
    private Long id;
    private String nombre;
    private Ciudad ciudad;
    private TipoMascota tipoMascota;
    private String password;
    private String direccion;
    private String telefono;
    private Boolean aceptaTerminos;

    public Usuario(Long id, String nombre, Ciudad ciudad, TipoMascota tipoMascota, String password, String direccion,
            String telefono, Boolean aceptaTerminos) throws UsuarioNoAceptaTerminosException {
        this.validarTerminos(aceptaTerminos);
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoMascota = tipoMascota;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
        this.aceptaTerminos = aceptaTerminos;
    }

    private void validarTerminos(Boolean aceptaTerminos) throws UsuarioNoAceptaTerminosException {
        if (Boolean.FALSE.equals(aceptaTerminos)) {
            throw new UsuarioNoAceptaTerminosException();
        }
    }
}
