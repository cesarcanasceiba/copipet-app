package com.ceiba.mascota.controlador;

import java.util.List;

import com.ceiba.mascota.consulta.ManejadorListaTipoMascota;
import com.ceiba.mascota.modelo.entidad.TipoMascota;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipomascota")
@Api(tags = { "Controlador consulta tipos de mascota" })
@RequiredArgsConstructor
public class ControladorConsultaTipoMascota {

    private final ManejadorListaTipoMascota manejadorlistaTipoMascota;

    @GetMapping
    @ApiOperation("Listar tipos de mascotas en el sistema")
    public List<TipoMascota> listar() {
        return this.manejadorlistaTipoMascota.ejecutar();
    }
}
