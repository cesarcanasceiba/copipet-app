package com.ceiba.citapeluqueria.comando.manejador;

import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import com.ceiba.citapeluqueria.comando.fabrica.FabricaCitaPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.ServicioCrearCitaPeluqueria;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.dao.DaoCiudad;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCitaPeluqueria {
    private final FabricaCitaPeluqueria fabricaCitaPeluqueria;
    private final ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria;
    private DaoCiudad daoCiudad;

    public ManejadorCrearCitaPeluqueria(FabricaCitaPeluqueria fabricaCitaPeluqueria,
            ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria, DaoCiudad daoCiudad) {
        this.fabricaCitaPeluqueria = fabricaCitaPeluqueria;
        this.servicioCrearCitaPeluqueria = servicioCrearCitaPeluqueria;
        this.daoCiudad = daoCiudad;
    }

    public Long ejecutar(ComandoCitaPeluqueria comandoCita) {
        CitaPeluqueria cita = this.fabricaCitaPeluqueria.crear(comandoCita);
        Ciudad ciudad = this.daoCiudad.encontrarPorId(comandoCita.getCiudad());
        return this.servicioCrearCitaPeluqueria.ejecutar(cita, ciudad).getId();
    }
}
