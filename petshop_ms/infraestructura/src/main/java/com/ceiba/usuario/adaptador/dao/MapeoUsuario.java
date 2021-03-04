package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.mascota.modelo.entidad.TipoMascota;
import com.ceiba.mascota.puerto.dao.DaoTipoMascota;
import com.ceiba.usuario.modelo.entidad.Usuario;

import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<Usuario>, MapperResult {

    private DaoCiudad daoCiudad;
    private DaoTipoMascota daoTipoMascota;

    public MapeoUsuario(DaoCiudad daoCiudad, DaoTipoMascota daoTipoMascota) {
        this.daoCiudad = daoCiudad;
        this.daoTipoMascota = daoTipoMascota;
    }

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        Ciudad ciudad = this.daoCiudad.encontrarPorId(rs.getLong("ciudad_id"));
        TipoMascota tipoMascota = this.daoTipoMascota.encontrarMascotaPorId(rs.getLong("tipom_mascota_id"));
        String password = rs.getString("password");
        String direccion = rs.getString("direccion");
        String telefono = rs.getString("telefono");
        Boolean aceptaTerminos = rs.getBoolean("acepta_terminos");
        return new Usuario(id, nombre, ciudad, tipoMascota, password, direccion, telefono, aceptaTerminos);
    }
}
