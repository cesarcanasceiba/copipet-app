package com.ceiba.pedido.modelo.entidad;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.currency.CurrencyType;
import com.ceiba.pedido.currency.converter.CurrencyConverterInterface;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.producto.modelo.entidad.Producto;

public class PedidoTest {

	private List lista;

	@Test
	public void pedidoSinValoresValidosProductosCitasTest() {
		final Date fechaPrueba = new Date();
		
		assertThrows(
				PedidoSinElementosException.class,
				()->new Pedido(null, null, null, fechaPrueba, null, null, null),
				"El pedido acepta valores nulos de productos y citas");
	}
	
	@Test
	public void pedidosConListasVaciasTest() {
		final Date fechaPrueba = new Date();
		
		assertThrows(
				PedidoConListasVaciasException.class,
				()->new Pedido(new ArrayList<>(), new ArrayList<>(), null, fechaPrueba, null, null, null),
				"El pedido no debe aceptar listas vacias de productos y citas");
	}

	@Test
	public void fechaInvalidaPedido() {
		final Date fechaPrueba = new Date();
		List lista = Mockito.mock(ArrayList.class);
        Mockito.when(lista.isEmpty()).thenReturn(false);
		
		assertThrows(
				FechaDePedidoInvalidaException.class,
				()->new Pedido(lista, lista, null, fechaPrueba, null, null, null),
				"El pedido acepta una fecha inválida");
	}
	
	@Test
	public void converterNoImplementadoTest() throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaPrueba = calendar.getTime();
		List lista = Mockito.mock(ArrayList.class);
		assertThrows(
				ConverterNoImplementadoException.class,
				()->new Pedido(lista, lista, null, fechaPrueba, CurrencyType.USD, null, null),
				"El pedido siendo en dolares no tiene un conversor de moneda");
	}
	
	@Test
	public void integracionPedidoConverter() throws ParseException, PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaPrueba = calendar.getTime();
		lista = Mockito.mock(ArrayList.class);
		CurrencyConverterInterface converter = new CurrencyConverterInterface() {
			
			@Override
			public Long fromUsDToCop(Long usD) {
				
				return usD * 5;
			}
		};
		Long valorInicial = Long.valueOf("100");
		Pedido instance = new Pedido(lista, lista, null, fechaPrueba, CurrencyType.USD, valorInicial, converter);
		Long nuevoValor = Long.valueOf("500");
		assertEquals(
				"El conversor se ejecuta adecuadamente",
				0, instance.getCostoTotal().compareTo(nuevoValor));
	}

	@Test
	public void calculoCostoTotalSobreListados() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException  {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaPrueba = formatter.parse("2021-02-23");
		Producto p1 = Mockito.mock(Producto.class);
		Producto p2 = Mockito.mock(Producto.class);
		Producto p3 = Mockito.mock(Producto.class);
		Producto p4 = Mockito.mock(Producto.class);

		Mockito.when(p1.getPrecio()).thenReturn(40L);
		Mockito.when(p2.getPrecio()).thenReturn(50L);
		Mockito.when(p3.getPrecio()).thenReturn(60L);
		Mockito.when(p4.getPrecio()).thenReturn(70L);

		CitaPeluqueria c1 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c1.calcularPrecio()).thenReturn(40L);
		CitaPeluqueria c2 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c2.calcularPrecio()).thenReturn(50L);
		CitaPeluqueria c3 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c3.calcularPrecio()).thenReturn(60L);
		CitaPeluqueria c4 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c4.calcularPrecio()).thenReturn(70L);

		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		listaProductos.add(p4);
		
		
		List<CitaPeluqueria> listaCitas = new ArrayList<>();
		listaCitas.add(c1);
		listaCitas.add(c2);
		listaCitas.add(c3);
		listaCitas.add(c4);

		Long expected = 440L;
		Pedido instance = new Pedido(listaProductos, listaCitas, null, fechaPrueba);
		assertEquals(
				"El pedido no calcula el precio total adecuedamente en función de sus listas de productos y citas",
				expected, instance.getCostoTotal());
	}
	
	@Test
	public void calculoCostoConBonoDescuento() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException  {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaPrueba = calendar.getTime();
		Date fechaBonoInicial = new Date();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaBonoFinal = calendar.getTime();
		
		Producto p1 = Mockito.mock(Producto.class);
		Producto p2 = Mockito.mock(Producto.class);
		Producto p3 = Mockito.mock(Producto.class);
		Producto p4 = Mockito.mock(Producto.class);

		Mockito.when(p1.getPrecio()).thenReturn(40L);
		Mockito.when(p2.getPrecio()).thenReturn(50L);
		Mockito.when(p3.getPrecio()).thenReturn(60L);
		Mockito.when(p4.getPrecio()).thenReturn(70L);

		CitaPeluqueria c1 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c1.calcularPrecio()).thenReturn(40L);
		CitaPeluqueria c2 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c2.calcularPrecio()).thenReturn(50L);
		CitaPeluqueria c3 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c3.calcularPrecio()).thenReturn(60L);
		CitaPeluqueria c4 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c4.calcularPrecio()).thenReturn(70L);

		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		listaProductos.add(p4);

		List<CitaPeluqueria> listaCitas = new ArrayList<>();
		listaCitas.add(c1);
		listaCitas.add(c2);
		listaCitas.add(c3);
		listaCitas.add(c4);

		BonoDescuento bono = Mockito.mock(BonoDescuento.class);
		Mockito.when(bono.getDescuento()).thenReturn(0.1f);
		Mockito.when(bono.getInicioVigencia()).thenReturn(fechaBonoInicial);
		Mockito.when(bono.getFinVigencia()).thenReturn(fechaBonoFinal);
		Long expected = 418L;
		Pedido instance = new Pedido(listaProductos, listaCitas, bono, fechaPrueba);
		assertEquals(
				"El pedido no calcula correctamente el descuento sobre el pedido",
				expected, instance.getCostoTotal());
	}
	
	@Test
	public void fechaNoCanjeableBonoDescuento() throws PedidoConListasVaciasException, ParseException, PesoNoAceptadoException  {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date fechaPrueba = calendar.getTime();
		Date fechaBonoInicial = formatter.parse("2020-01-02");
		Date fechaBonoFinal = formatter.parse("2020-01-05");
		Producto p1 = Mockito.mock(Producto.class);
		Producto p2 = Mockito.mock(Producto.class);
		Producto p3 = Mockito.mock(Producto.class);
		Producto p4 = Mockito.mock(Producto.class);

		Mockito.when(p1.getPrecio()).thenReturn(40L);
		Mockito.when(p2.getPrecio()).thenReturn(50L);
		Mockito.when(p3.getPrecio()).thenReturn(60L);
		Mockito.when(p4.getPrecio()).thenReturn(70L);

		CitaPeluqueria c1 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c1.calcularPrecio()).thenReturn(40L);
		CitaPeluqueria c2 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c2.calcularPrecio()).thenReturn(50L);
		CitaPeluqueria c3 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c3.calcularPrecio()).thenReturn(60L);
		CitaPeluqueria c4 = Mockito.mock(CitaPeluqueria.class);
		Mockito.when(c4.calcularPrecio()).thenReturn(70L);

		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		listaProductos.add(p4);

		List<CitaPeluqueria> listaCitas = new ArrayList<>();
		listaCitas.add(c1);
		listaCitas.add(c2);
		listaCitas.add(c3);
		listaCitas.add(c4);

		BonoDescuento bono = Mockito.mock(BonoDescuento.class);
		Mockito.when(bono.getDescuento()).thenReturn(0.1f);
		Mockito.when(bono.getInicioVigencia()).thenReturn(fechaBonoInicial);
		Mockito.when(bono.getFinVigencia()).thenReturn(fechaBonoFinal);
		Long expected = 440L;
		Pedido instance = new Pedido(listaProductos, listaCitas, bono, fechaPrueba);
		assertEquals(
				"El pedido hace descuentos con un bono de fecha inválida",
				expected, instance.getCostoTotal());
	}
}
