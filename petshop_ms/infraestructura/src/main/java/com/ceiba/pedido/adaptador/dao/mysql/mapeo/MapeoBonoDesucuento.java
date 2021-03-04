package com.ceiba.pedido.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import org.springframework.jdbc.core.RowMapper;

public class MapeoBonoDesucuento implements RowMapper<BonoDescuento>, MapperResult {

    @Override
    public BonoDescuento mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String codigo = rs.getString("codigo");
        Date inicioVigencia = rs.getDate("inicioVigencia");
        Date finVigencia = rs.getDate("finVigencia");
        Float descuento = rs.getFloat("descuento");
        return new BonoDescuento(id, codigo, inicioVigencia, finVigencia, descuento);
    }
}
