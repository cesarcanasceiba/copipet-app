package com.ceiba.citapeluqueria.controlador;

import java.util.List;

import com.ceiba.citapeluqueria.consulta.ManejadorListaServicioPeluqueria;
import com.ceiba.citapeluqueria.modelo.entidad.ServicioPeluqueria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/serviciopeluqueria")
@Api(tags = { "Controlador consulta servicios peluqueria" })
@RequiredArgsConstructor
public class ControladorConsultaServicioPeluqueria {
    private final ManejadorListaServicioPeluqueria manejadorServicioPeluqueria;

    @GetMapping
    @ApiOperation("Listar ciudades en el sistema")
    public List<ServicioPeluqueria> listar() {
        return this.manejadorServicioPeluqueria.ejecutar();
    }
}
