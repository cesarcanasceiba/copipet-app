package com.ceiba.usuario.testdatabuilder;

import com.ceiba.TestDataBuilderInterface;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

public class UsuarioDtoTestDataBuilder implements TestDataBuilderInterface<DtoUsuario> {

	private long id;
	private String nombreUsuario;
	private String direccion;
	private String telefono;
	private boolean aceptaTerminos;
	private Long ciudad;
	private Long tipoMascota;

	public UsuarioDtoTestDataBuilder() {
		this.id = 1L;
		this.nombreUsuario = "1234";
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

	public UsuarioDtoTestDataBuilder setId(long id) {
		this.id = id;
		return this;
	}

	public UsuarioDtoTestDataBuilder setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public UsuarioDtoTestDataBuilder setTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	public UsuarioDtoTestDataBuilder setTipoMascota(long tipoMascota) {
		this.tipoMascota = tipoMascota;
		return this;
	}

	public UsuarioDtoTestDataBuilder setAceptaTerminos(boolean aceptaTerminos) {
		this.aceptaTerminos = aceptaTerminos;
		return this;
	}

	@Override
	public DtoUsuario build() {
		return new DtoUsuario(id, nombreUsuario, direccion, telefono, aceptaTerminos, ciudad, tipoMascota);
	}

}
