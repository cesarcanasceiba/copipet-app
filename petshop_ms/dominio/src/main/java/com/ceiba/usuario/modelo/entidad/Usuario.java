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

    public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setAceptaTerminos(Boolean aceptaTerminos) throws UsuarioNoAceptaTerminosException {
		this.validarTerminos(aceptaTerminos);
		this.aceptaTerminos = aceptaTerminos;
	}

	private void validarTerminos(Boolean aceptaTerminos) throws UsuarioNoAceptaTerminosException {
		if(Boolean.FALSE.equals(aceptaTerminos)) throw new UsuarioNoAceptaTerminosException();
	}
}
