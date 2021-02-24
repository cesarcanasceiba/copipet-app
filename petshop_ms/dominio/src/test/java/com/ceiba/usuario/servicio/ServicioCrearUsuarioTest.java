package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioCrearUsuarioTest {

	@Test
	void usuarioExiste() {
		RepositorioUsuario repositorio = Mockito.mock(RepositorioUsuario.class);
		Mockito.when(repositorio.existe(null)).thenReturn(true);
		Usuario user = Mockito.mock(Usuario.class);
		ServicioCrearUsuario servicio = new ServicioCrearUsuario(repositorio);
		assertThrows(ExcepcionDuplicidad.class, ()->servicio.ejecutar(user));
				
	}
}
