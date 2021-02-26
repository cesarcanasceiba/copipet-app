package com.ceiba.pedido.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.testdatabuilder.CitaPeluqueriaTestDataBuilder;
import com.ceiba.pedido.currency.TipoMoneda;
import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.testdatabuilder.BonoDescuentoTestDataBuilder;
import com.ceiba.pedido.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

class PedidoTest {
	
	@Test
	void verificarCopiaFecha() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.HOUR_OF_DAY, 4);
		Date fechaPrueba = cl.getTime();
		Pedido pedido = new PedidoTestDataBuilder().setFechaEntrega(fechaPrueba).build();
		assertNotSame(fechaPrueba, pedido.getFechaEntrega());
	}
	
	@Test
	void comparaPedidosIguales() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		Pedido p1 = new PedidoTestDataBuilder().build();
		Pedido p2 = new PedidoTestDataBuilder().setId(2L).build();
		
		assertNotEquals(p1, p2);
	}

	@Test
	void pedidoSinValoresValidosProductosCitasTest() {
		final Date fechaPrueba = new Date();
		assertThrows(
				NullPointerException.class,
				()->new PedidoTestDataBuilder()
					.setProductos(null)
					.setCitasPeluqueria(null)
					.setFechaEntrega(fechaPrueba)
                    .build(),
				"El pedido acepta valores nulos de productos y citas");
	}
	
	@Test
	void pedidosConListasVaciasTest() {
		final Date fechaPrueba = new Date();
		
		assertThrows(
				PedidoConListasVaciasException.class,
				()->new PedidoTestDataBuilder()
					.setProductos(new ArrayList<>())
					.setCitasPeluqueria(new ArrayList<>())
					.setBonoDescuento(null)
					.setFechaEntrega(fechaPrueba)
					.setCurrencyConverter(null).build(),
				"El pedido no debe aceptar listas vacias de productos y citas");
	}

	@Test
	void fechaInvalidaPedido() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date fechaPrueba = calendar.getTime();
		assertThrows(
				FechaDePedidoInvalidaException.class,
				()->new PedidoTestDataBuilder()
					.setFechaEntrega(fechaPrueba)
					.build(),
				"El pedido acepta una fecha inválida");
	}

	@Test
	void converterNoImplementadoTest() throws ParseException {

		assertThrows(
				ConverterNoImplementadoException.class,
				()->new PedidoTestDataBuilder()
					.setBonoDescuento(null)
					.setCurrency(TipoMoneda.USD)
					
					.setCurrencyConverter(null).build(),
				"El pedido siendo en dolares no tiene un conversor de moneda");
	}

	@Test
	void integracionPedidoConverter() throws ParseException, PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, FechaInicioCitaInvalidaException {

		final Long factorConversion = 5L;		
		ConversorMonedaInterface converter = (Long usD) -> usD * factorConversion;
		Pedido instance = new PedidoTestDataBuilder()
				.setCurrency(TipoMoneda.USD)
				.setCurrencyConverter(converter).build();

		Long costoTotal = new PedidoTestDataBuilder().build().getCostoTotal();
		Long expected = costoTotal * factorConversion;
		assertEquals(
				0, instance.getCostoTotal().compareTo(expected),
				"El conversor se ejecuta adecuadamente");
	}

	@Test
	void calculoCostoTotalSobreListados() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException, PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, FechaInicioCitaInvalidaException  {
		Long valorProducto = 10L;
		List<Producto> productos= new ArrayList<>();
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		
		List<CitaPeluqueria> citas = new ArrayList<>();
		citas.add(new CitaPeluqueriaTestDataBuilder().build());
		citas.add(new CitaPeluqueriaTestDataBuilder().build());
		citas.add(new CitaPeluqueriaTestDataBuilder().build());

		Pedido instance = new PedidoTestDataBuilder()
				.setProductos(productos)
				.setCitasPeluqueria(citas)
				.build();

		Long costoCitas = new CitaPeluqueriaTestDataBuilder().build().getCostoCita() * citas.size();
		Long costoProductos = valorProducto * productos.size();
		Long expected = (costoCitas + costoProductos);
		
		assertEquals(
				expected, instance.getCostoTotal(),
				"El pedido no calcula el precio total adecuedamente en función de sus listas de productos y citas");
	}
	
	@Test
	void calculoCostoConBonoDescuento() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException, PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, FechaInicioCitaInvalidaException  {
		float descuento = 0.1F;

		Long valorProducto = 10L;
		List<Producto> productos= new ArrayList<>();
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		productos.add(new ProductoTestDataBuilder().setPrecio(valorProducto).build());
		
		List<CitaPeluqueria> citas = new ArrayList<>();
		citas.add(new CitaPeluqueriaTestDataBuilder().build());
		citas.add(new CitaPeluqueriaTestDataBuilder().build());
		citas.add(new CitaPeluqueriaTestDataBuilder().build());
		
		BonoDescuento bonoDescuento = new BonoDescuentoTestDataBuilder().setDescuento(descuento).build();
		Pedido instance = new PedidoTestDataBuilder()
				.setProductos(productos)
				.setCitasPeluqueria(citas)
				.setBonoDescuento(bonoDescuento).build();

		Long costoCitas = new CitaPeluqueriaTestDataBuilder().build().getCostoCita() * citas.size();
		Long costoProductos = (long) (valorProducto * productos.size() * (1 - descuento));
		Long expected = (costoCitas + costoProductos);
		assertEquals(
				expected, instance.getCostoTotal(),
				"El pedido no calcula correctamente el descuento sobre el pedido");
	}

	@Test
	void fechaNoCanjeableBonoDescuento() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException, PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, FechaInicioCitaInvalidaException  {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaBonoInicial = formatter.parse("2020-01-02");
		Date fechaBonoFinal = formatter.parse("2020-01-05");

		BonoDescuento bono = new BonoDescuentoTestDataBuilder()
				.setInicioVigencia(fechaBonoInicial)
				.setFinVigencia(fechaBonoFinal)
				.setDescuento(0.1F).build();
		Pedido instance = new PedidoTestDataBuilder().setBonoDescuento(bono).build();
		Long expected = new PedidoTestDataBuilder().build().getCostoTotal();
		assertEquals(
				expected, instance.getCostoTotal(),
				"El pedido hace descuentos con un bono de fecha inválida");
	}
	
	@Test
	void metodoEqualsSobreNull() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		Pedido pedido = new PedidoTestDataBuilder().build();
		Object other = null;
		boolean result = pedido.equals(other);
		assertFalse(result);
		
	}
	
	@Test
	void metodoEqualsSobreObjetoDiferenteClase() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		Pedido pedido = new PedidoTestDataBuilder().build();
		Object other = "objeto String";
		boolean result = pedido.equals(other);
		assertFalse(result);
	}
	
	@Test
	void testHashCode() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		Pedido pedido = new PedidoTestDataBuilder().build();
		assertNotEquals(0, pedido.hashCode());
	}
	
	@Test
	void pedidoSinProductosValido() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().setProductos(null);
		assertThrows(NullPointerException.class,()->pedido.build());
	}
	
	@Test
	void pedidosinCitasValido() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().setCitasPeluqueria(null);
		assertThrows(NullPointerException.class,()->pedido.build());
	}
	
	@Test
	void pedidosinValidoSinCitasNiProductos() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().setCitasPeluqueria(new ArrayList<>()).setProductos(new ArrayList<>());
		assertThrows(PedidoConListasVaciasException.class,()->pedido.build());
	}
	
	@Test
	void pedidosinValidoSinCitas() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException, PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		PedidoTestDataBuilder pedido = new PedidoTestDataBuilder().setCitasPeluqueria(new ArrayList<>());
		assertDoesNotThrow(()->pedido.build());
	}
}
