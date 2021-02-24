package com.ceiba.usuario.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
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
        this.ciudad = new Ciudad(1L, "Bogotá");
        this.tipoMascota = new TipoMascota(1L, "Perro");
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
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombre(nombreUsuario);
        user.setCiudad(ciudad);
        user.setTipoMascota(tipoMascota);
        user.setPassword(clave);
        user.setDireccion(direccion);
        user.setTelefono(telefono);
        user.setAceptaTerminos(aceptaTerminos);
    	return user;
    }
}
