package com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoPeluquero;
import com.ceiba.citapeluqueria.puerto.dao.DaoServicioPeluqueria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.jdbc.core.RowMapper;

public class MapeoCitaPeluqueria implements RowMapper<CitaPeluqueria>, MapperResult {

    private DaoPeluquero daoPeluquero;
    private DaoServicioPeluqueria daoServicioPeluqueria;
    private DaoUsuario daoUsuario;

    public MapeoCitaPeluqueria(DaoPeluquero daoPeluquero, DaoServicioPeluqueria daoServicioPeluqueria,
            DaoUsuario daoUsuario) {
        this.daoPeluquero = daoPeluquero;
        this.daoServicioPeluqueria = daoServicioPeluqueria;
        this.daoUsuario = daoUsuario;
    }

    @Override
    public CitaPeluqueria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Peluquero peluquero = this.daoPeluquero.encontrarPorId(rs.getLong("peluquero_id"));
        List<ServicioPeluqueria> servicios = this.daoServicioPeluqueria.encontrarServiciosPorCitaPeluqueria(id);
        Date fechaInicio = rs.getDate("hora_inicio");
        Usuario usuario = this.daoUsuario.encontrarPorId(rs.getLong("usuario_id"));
        String fotoMascota = rs.getString("fotoMascota");
        Float pesoMascota = rs.getFloat("pesoMascota");
        return new CitaPeluqueria(id, peluquero, servicios, fechaInicio, usuario, fotoMascota, pesoMascota);
    }
}
