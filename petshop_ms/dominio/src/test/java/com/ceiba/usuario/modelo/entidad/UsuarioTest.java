package com.ceiba.usuario.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.ceiba.usuario.servicio.exception.UsuarioNoAceptaTerminosException;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;

class UsuarioTest {

	@Test
    void usuarioValidaTerminosYCondiciones() {
    	
        assertThrows(
        		UsuarioNoAceptaTerminosException.class,
        		()->new UsuarioTestDataBuilder().conAceptaTerminos(false).build(),
        		"");
    }
	
	@Test
    void generaInstanciaUsuario() {
    	
        assertDoesNotThrow(
        		()->new UsuarioTestDataBuilder().build(),
        		"NO se generó el usuario");
    }
}
