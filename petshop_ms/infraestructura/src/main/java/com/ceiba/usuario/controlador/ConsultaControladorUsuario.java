package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@Api(tags = { "Controlador consulta usuario" })
@RequiredArgsConstructor
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }
}
