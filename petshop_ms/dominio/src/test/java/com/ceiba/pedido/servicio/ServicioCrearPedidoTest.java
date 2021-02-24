package com.ceiba.pedido.servicio;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.testdatabuilder.PedidoTestDataBuilder;

class ServicioCrearPedidoTest {

	@Test
	void crearPedido() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException {
		Pedido pedido = new PedidoTestDataBuilder().build();
		RepositorioPedido repositorio = Mockito.mock(RepositorioPedido.class);
		Mockito.when(repositorio.crear(pedido)).thenReturn(pedido);
		ServicioCrearPedido servicio = new ServicioCrearPedido(repositorio);
		assertTrue("", servicio.ejecutar(pedido).equals(pedido));
	}
}
