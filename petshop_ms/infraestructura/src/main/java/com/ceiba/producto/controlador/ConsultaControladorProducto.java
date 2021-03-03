package com.ceiba.producto.controlador;

import java.util.List;

import com.ceiba.producto.consulta.ManejadorListaProductosPorCategoria;
import com.ceiba.producto.consulta.ManejadorListaProductosResumen;
import com.ceiba.producto.consulta.ManejadorProductoDetalle;
import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/producto")
@Api(tags = { "Controlador comando cita peluqueria" })
public class ConsultaControladorProducto {

    @Autowired
    ManejadorListaProductosResumen manejadorListaProductosResumen;

    @Autowired
    ManejadorListaProductosPorCategoria manejadorListaProductosPorCategoria;

    @Autowired
    ManejadorProductoDetalle manejadorProductoDetalle;

    @GetMapping
    @ApiOperation("Listar productos en versión resumida")
    public List<ProductoResumenDTO> listar(@RequestParam(name = "categoria", required = false) Long categoriaId) {
        if (categoriaId != null) {
            return this.manejadorListaProductosPorCategoria.ejecutar(categoriaId);
        } else {
            return this.manejadorListaProductosResumen.ejecutar();
        }
    }

    @GetMapping("{id}")
    @ApiOperation("Listar productos en versión resumida")
    public ProductoDetalleDTO consultarProductoDetalle(@PathVariable Long id) {
        return this.manejadorProductoDetalle.ejecutar(id);
    }
}
