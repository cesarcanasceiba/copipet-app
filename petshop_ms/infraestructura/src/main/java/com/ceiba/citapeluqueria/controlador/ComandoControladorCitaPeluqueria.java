package com.ceiba.citapeluqueria.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import com.ceiba.citapeluqueria.comando.manejador.ManejadorCrearCitaPeluqueria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/citapeluqueria")
@Api(tags = { "Controlador comando cita peluqueria" })
@RequiredArgsConstructor
public class ComandoControladorCitaPeluqueria {

    private final ManejadorCrearCitaPeluqueria manejadorCrearCitaPeluqueria;

    @PostMapping
    @ApiOperation("Crear cita peluqueria")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCitaPeluqueria comandoCitaPeluqueria) {
        return manejadorCrearCitaPeluqueria.ejecutar(comandoCitaPeluqueria);
    }
}
