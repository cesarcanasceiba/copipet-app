package com.ceiba.citapeluqueria.adaptador.repositorio.mysql;

import java.util.List;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCitaPeluqueriaMysql implements RepositorioCitaPeluqueria {

        @SqlStatement(namespace = "citapeluqueria", value = "crear")
        private static String sqlCrearCita;

        @SqlStatement(namespace = "citapeluqueria", value = "existenCitasSimultaneas")
        private static String sqlExistenCitasSimultaneas;

        @SqlStatement(namespace = "citapeluqueria", value = "asociarServiciosACitas")
        private static String sqlAsociarServiciosACitas;

        private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
        private DaoCitaPeluqueria daoCitaPeluqueria;

        public RepositorioCitaPeluqueriaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
                        DaoCitaPeluqueria daoCitaPeluqueria) {
                this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
                this.daoCitaPeluqueria = daoCitaPeluqueria;
        }

        @Override
        public CitaPeluqueria crear(CitaPeluqueria citaPeluqueria) {
                MapeoCitaPeluqueriaMysql mapeoCita = new MapeoCitaPeluqueriaMysql(citaPeluqueria.getFechaInicio(),
                                citaPeluqueria.getFechaFinal(), citaPeluqueria.getFotoMascota(),
                                citaPeluqueria.getPesoMascota(), citaPeluqueria.getCostoCita(),
                                citaPeluqueria.getPeluquero().getId(), citaPeluqueria.getUsuario().getId());
                Long nuevaCitaId = this.customNamedParameterJdbcTemplate.crear(mapeoCita, sqlCrearCita);
                citaPeluqueria.getServicios().stream().map(ServicioPeluqueria::getId)
                                .map(servicioId -> new MapeoAsociarServiciosACitaPeluqueria(nuevaCitaId, servicioId))
                                .map(datosInsertar -> this.customNamedParameterJdbcTemplate.crear(datosInsertar,
                                                sqlAsociarServiciosACitas))
                                .toArray();
                return daoCitaPeluqueria.consultarPorId(nuevaCitaId);
        }

        @Override
        public boolean existenCitasSimultaneas(CitaPeluqueria citaPeluqueria) {
                MapSqlParameterSource params = new MapSqlParameterSource();
                params.addValue("hora_inicio", citaPeluqueria.getFechaInicio());
                params.addValue("hora_final", citaPeluqueria.getFechaFinal());
                List<Integer> resultado = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                                .queryForList(sqlExistenCitasSimultaneas, params, Integer.class);
                if (resultado.size() == 0) {
                        return false;
                } else {
                        return resultado.get(0) > 0;
                }
        }
}
