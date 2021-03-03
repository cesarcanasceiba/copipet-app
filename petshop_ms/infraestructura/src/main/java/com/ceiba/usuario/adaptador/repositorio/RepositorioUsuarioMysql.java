package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private DaoUsuario daoUsuario;

    @SqlStatement(namespace = "usuario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "usuario", value = "existe")
    private static String sqlExiste;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoUsuario daoUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoUsuario = daoUsuario;
    }

    @Override
    public DtoUsuario crear(Usuario usuario) {
        MapeoUsuarioMysql nuevoUsuario = new MapeoUsuarioMysql(usuario.getId(), usuario.getNombre(),
                usuario.getPassword(), usuario.getDireccion(), usuario.getTelefono(), usuario.getAceptaTerminos(),
                usuario.getCiudad().getId(), usuario.getTipoMascota().getId());
        Long newUserId = this.customNamedParameterJdbcTemplate.crear(nuevoUsuario, sqlCrear);
        return daoUsuario.recuperarUsuarioDto(newUserId);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
                paramSource, Boolean.class);
    }
}
