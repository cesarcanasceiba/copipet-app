package com.ceiba.pedido.controlador;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@Api(tags = { "Controlador comando cita peluqueria" })
@RequiredArgsConstructor
public class ComandoControladorPedido {

    private final ManejadorCrearPedido manejadorCrearPedido;

    @PostMapping
    @ApiOperation("Crear pedido")
    public Pedido crear(@RequestBody ComandoPedido comandoPedido) {
        return manejadorCrearPedido.ejecutar(comandoPedido);
    }
}
