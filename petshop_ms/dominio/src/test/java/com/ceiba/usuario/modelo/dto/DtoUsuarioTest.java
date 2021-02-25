package com.ceiba.usuario.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.testdatabuilder.UsuarioDtoTestDataBuilder;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;

class DtoUsuarioTest {

	@Test
	void controlDeValoresNulosEnInstancia() {
		UsuarioDtoTestDataBuilder user = new UsuarioDtoTestDataBuilder().setNombreUsuario(null);
		assertThrows(NullPointerException.class, ()->user.build());
	}

}
