package com.ceiba.pedido.servicio;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.generadorciudad.GeneradorCiudadValidaCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.ServicioCrearCitaPeluqueria;
import com.ceiba.citapeluqueria.testdatabuilder.CitaPeluqueriaTestDataBuilder;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.testdatabuilder.PedidoTestDataBuilder;

class ServicioCrearPedidoTest {

	@Test
	void crearPedido() throws PedidoSinElementosException, PedidoConListasVaciasException,
			FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException,
			FechaInicioCitaInvalidaException {
		Pedido pedido = new PedidoTestDataBuilder().build();
		Ciudad ciudadValida = new CiudadTestDataBuilder().build();
		GeneradorCiudadValidaCitaPeluqueria generadorCiudadValida = Mockito
				.mock(GeneradorCiudadValidaCitaPeluqueria.class);

		Mockito.when(generadorCiudadValida.get()).thenReturn(ciudadValida);

		CitaPeluqueria citaPeluqueria = new CitaPeluqueriaTestDataBuilder().build();
		RepositorioCitaPeluqueria repositorioCita = Mockito.mock(RepositorioCitaPeluqueria.class);
		Mockito.when(repositorioCita.existenCitasSimultaneas(citaPeluqueria)).thenReturn(false);
		ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria = new ServicioCrearCitaPeluqueria(repositorioCita,
				generadorCiudadValida);

		RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
		Mockito.when(repositorioPedido.crear(pedido)).thenReturn(pedido);

		ServicioCrearPedido servicio = new ServicioCrearPedido(repositorioPedido, servicioCrearCitaPeluqueria);
		assertTrue(servicio.ejecutar(pedido, ciudadValida).equals(pedido), "");
	}
}
