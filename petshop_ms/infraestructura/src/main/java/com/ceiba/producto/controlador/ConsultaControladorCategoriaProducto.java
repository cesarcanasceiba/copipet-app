package com.ceiba.producto.controlador;

import java.util.List;

import com.ceiba.producto.consulta.ManejadorListaCategoriaProducto;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categoriaproducto")
@Api(tags = { "Controlador comando cita peluqueria" })
@RequiredArgsConstructor
public class ConsultaControladorCategoriaProducto {

    private final ManejadorListaCategoriaProducto manejadorListaCategoriaProducto;

    @GetMapping
    @ApiOperation("Listar categorias de productos en versión resumida")
    public List<CategoriaProducto> listar() {
        return this.manejadorListaCategoriaProducto.ejecutar();
    }
}
