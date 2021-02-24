package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.exception.UsuarioNoAceptaTerminosException;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarUsuarioTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() throws UsuarioNoAceptaTerminosException {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
