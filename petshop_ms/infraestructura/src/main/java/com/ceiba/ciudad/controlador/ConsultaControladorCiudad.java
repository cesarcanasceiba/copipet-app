package com.ceiba.ciudad.controlador;

import java.util.List;

import com.ceiba.ciudad.consulta.ManejadorListaCiudad;
import com.ceiba.ciudad.modelo.entidad.Ciudad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ciudad")
@Api(tags = { "Controlador consulta ciudad" })
@RequiredArgsConstructor
public class ConsultaControladorCiudad {

    private final ManejadorListaCiudad manejadorListaCiudad;

    @GetMapping
    @ApiOperation("Listar ciudades en el sistema")
    public List<Ciudad> listar() {
        return this.manejadorListaCiudad.ejecutar();
    }
}
