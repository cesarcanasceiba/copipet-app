package com.ceiba.citapeluqueria.adaptador.dao.mysql.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

public class MapeoServicioPeluqueria implements RowMapper<ServicioPeluqueria>, MapperResult {

    @Override
    public ServicioPeluqueria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        return new ServicioPeluqueria(id, nombre);
    }
}
