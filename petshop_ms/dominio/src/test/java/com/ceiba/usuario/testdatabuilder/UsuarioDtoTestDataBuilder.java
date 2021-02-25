package com.ceiba.usuario.testdatabuilder;

import com.ceiba.TestDataBuilderInterface;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

public class UsuarioDtoTestDataBuilder implements TestDataBuilderInterface<DtoUsuario>{

	private long id;
	private String nombreUsuario;
	private String clave;
	private String direccion;
	private String telefono;
	private boolean aceptaTerminos;
	private long ciudad;
	private long tipoMascota;

	public void UsuarioTestDataBuilder() {
		this.id = 1L;
	    nombreUsuario = "1234";
	    clave = "1234";
	    this.direccion = "Dir base";
	    this.telefono = "132312";
	    this.aceptaTerminos = true;
	    this.ciudad = 1L;
	    this.tipoMascota = 1L;
    }

	public UsuarioDtoTestDataBuilder setNombreUsuario(String nombreUsuario) {
	    this.nombreUsuario = nombreUsuario;
	    return this;
	}
	
	public UsuarioDtoTestDataBuilder setCiudad(Long ciudad) {
		this.ciudad = ciudad;
		return this;
	}
	
	public UsuarioDtoTestDataBuilder setAceptaTerminos(boolean aceptaTerminos) {
		this.aceptaTerminos = aceptaTerminos;
		return this;
	}
	@Override
	public DtoUsuario build() {
		return new DtoUsuario(id, nombreUsuario, clave, direccion, telefono, aceptaTerminos, clave, tipoMascota);
	}

}
