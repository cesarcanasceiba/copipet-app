package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * 
     * @return los usuarios
     */
    List<DtoUsuario> listar();

    /**
     * Recupera un objeto de la entidad de tipo T con id de tipo R
     * 
     * @param <R> Tipo del id de la entidad T
     * @param id  identificador de la entidad
     * @return instancia de la entidad T
     */
    Usuario encontrarPorId(Long id);

    /**
     * Recupera el dto de un usuario por ID
     * 
     * @param id id del usuario
     * @return DTO del usuario
     */
    DtoUsuario recuperarUsuarioDto(Long id);
}
