package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.puerto.dao.DaoTipoMascota;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private DaoTipoMascota daoTipoMascota;

    private DaoCiudad daoCiudad;

    @SqlStatement(namespace = "usuario", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "usuario", value = "consultarPorId")
    private static String consultarPorId;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoTipoMascota daoTipoMascota, DaoCiudad daoCiudad) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoTipoMascota = daoTipoMascota;
        this.daoCiudad = daoCiudad;
    }

    @Override
    public List<DtoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
                new MapeoUsuarioDto());
    }

    @Override
    public Usuario encontrarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoUsuario(daoCiudad, daoTipoMascota));
    }

    @Override
    public DtoUsuario recuperarUsuarioDto(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoUsuarioDto());
    }
}
