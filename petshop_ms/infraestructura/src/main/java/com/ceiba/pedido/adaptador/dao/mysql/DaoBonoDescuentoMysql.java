package com.ceiba.pedido.adaptador.dao.mysql;

import java.util.Date;
import java.util.Objects;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.adaptador.dao.mysql.mapeo.MapeoBonoDesucuento;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import com.ceiba.pedido.puerto.dao.DaoBonoDescuento;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoBonoDescuentoMysql implements DaoBonoDescuento {

    @SqlStatement(namespace = "bonodescuento", value = "consultarBonoPorId")
    private static String obtenerBonoPorId;

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoBonoDescuentoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public BonoDescuento obtenerBonoPorId(Long id) {
        if (Objects.isNull(id) || id.equals(0L)) {
            return new BonoDescuento(null, "NA", new Date(), new Date(), null);
        } else {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(obtenerBonoPorId, params, new MapeoBonoDesucuento());
        }
    }
}
