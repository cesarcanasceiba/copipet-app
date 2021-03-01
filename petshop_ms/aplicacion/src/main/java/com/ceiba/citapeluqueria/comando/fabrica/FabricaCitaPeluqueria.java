package com.ceiba.citapeluqueria.comando.fabrica;

import java.util.List;

import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;
import com.ceiba.citapeluqueria.puerto.dao.DaoPeluquero;
import com.ceiba.citapeluqueria.puerto.dao.DaoServicioPeluqueria;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.stereotype.Component;

@Component
public class FabricaCitaPeluqueria {

    private final DaoPeluquero daoPeluquero;
    private final DaoServicioPeluqueria daoServicioPeluqueria;
    private DaoUsuario daoUsuario;

    public FabricaCitaPeluqueria(DaoPeluquero daoPeluquero, DaoServicioPeluqueria daoServicioPeluqueria,
            DaoUsuario daoUsuario) {
        this.daoPeluquero = daoPeluquero;
        this.daoServicioPeluqueria = daoServicioPeluqueria;
        this.daoUsuario = daoUsuario;
    }

    public CitaPeluqueria crear(ComandoCitaPeluqueria comandoCita) {
        Peluquero peluquero = this.daoPeluquero.encontrarPorId(comandoCita.getId());
        List<ServicioPeluqueria> servicios = this.daoServicioPeluqueria
                .encontrarServiciosPorId(comandoCita.getServicios());
        Usuario usuario = this.daoUsuario.encontrarPorId(comandoCita.getUsuario());

        return new CitaPeluqueria(comandoCita.getId(), peluquero, servicios, comandoCita.getFechaInicio(), usuario,
                comandoCita.getFotoMascota(), comandoCita.getPesoMascota());
    }
}
