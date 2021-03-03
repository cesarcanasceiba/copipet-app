package com.ceiba.usuario.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.usuario.testdatabuilder.UsuarioDtoTestDataBuilder;

class DtoUsuarioTest {

	@Test
	void controlNombreNulo() {
		UsuarioDtoTestDataBuilder user = new UsuarioDtoTestDataBuilder().setNombreUsuario(null);
		assertThrows(NullPointerException.class, () -> user.build());
	}

	@Test
	void getValorNombre() {
		String nombre = "nombre 1";
		DtoUsuario user = new UsuarioDtoTestDataBuilder().setNombreUsuario(nombre).build();
		assertEquals(nombre, user.getNombreUsuario());
	}

	@Test
	void getValorCiudad() {
		Long ciudad = 1L;
		DtoUsuario user = new UsuarioDtoTestDataBuilder().setCiudad(ciudad).build();
		assertEquals(ciudad, user.getCiudad());
	}

	@Test
	void getDireccion() {
		String nombre = "nombre 1";
		DtoUsuario user = new UsuarioDtoTestDataBuilder().setDireccion(nombre).build();
		assertEquals(nombre, user.getDireccion());
	}

	@Test
	void getTelefono() {
		String nombre = "nombre 1";
		DtoUsuario user = new UsuarioDtoTestDataBuilder().setTelefono(nombre).build();
		assertEquals(nombre, user.getTelefono());
	}

}
