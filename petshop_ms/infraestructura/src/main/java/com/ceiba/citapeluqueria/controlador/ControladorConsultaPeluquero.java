package com.ceiba.citapeluqueria.controlador;

import java.util.List;

import com.ceiba.citapeluqueria.consulta.ManejadorListaPeluquero;
import com.ceiba.citapeluqueria.modelo.entidad.Peluquero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/peluquero")
@Api(tags = { "Controlador consulta ciudad" })
@RequiredArgsConstructor
public class ControladorConsultaPeluquero {
    private final ManejadorListaPeluquero manejadorPeluquero;

    @GetMapping
    @ApiOperation("Listar peluqueros en el sistema")
    public List<Peluquero> listar() {
        return this.manejadorPeluquero.ejecutar();
    }
}
