package com.ceiba.citapeluqueria.adaptador.dao.mysql;

import java.util.List;

import com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo.MapeoCitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoPeluquero;
import com.ceiba.citapeluqueria.puerto.dao.DaoServicioPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoCitaPeluqueriaMysql implements DaoCitaPeluqueria {

    @SqlStatement(namespace = "citapeluqueria", value = "consultarPorId")
    private static String consultarPorId;

    @SqlStatement(namespace = "citapeluqueria", value = "consultarCitasPorPedido")
    private static String consultarCitasPorPedido;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private DaoPeluquero daoPeluquero;
    private DaoServicioPeluqueria daoServicioPeluqueria;
    private DaoUsuario daoUsuario;

    public DaoCitaPeluqueriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
            DaoPeluquero daoPeluquero, DaoServicioPeluqueria daoServicioPeluqueria, DaoUsuario daoUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.daoPeluquero = daoPeluquero;
        this.daoServicioPeluqueria = daoServicioPeluqueria;
        this.daoUsuario = daoUsuario;
    }

    @Override
    public CitaPeluqueria consultarPorId(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultarPorId,
                params, new MapeoCitaPeluqueria(daoPeluquero, daoServicioPeluqueria, daoUsuario));
    }

    @Override
    public List<CitaPeluqueria> consultarPorPedido(Long pedidoId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("pedidoId", pedidoId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(consultarCitasPorPedido,
                params, new MapeoCitaPeluqueria(daoPeluquero, daoServicioPeluqueria, daoUsuario));
    }
}
