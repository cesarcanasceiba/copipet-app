package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {

    /**
     * Crea un nuevo usuario
     * 
     * @return
     */
    DtoUsuario crear(Usuario usuario);

    /**
     * Permite validar si existe un usuario con un nombre
     * 
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);
}
