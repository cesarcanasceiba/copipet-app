package com.ceiba.pedido.testdatabuilder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.currency.CurrencyType;
import com.ceiba.pedido.currency.converter.CurrencyConverterInterface;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;

public class PedidoTestDataBuilder {
    private List<Producto> productos;
    private List<CitaPeluqueria> citasPeluqueria;
    private BonoDescuento bonoDescuento;
    private Long costoTotal;
    private Date fechaEntrega;
    private CurrencyType currency;
	private CurrencyConverterInterface currencyConverter;
	private long id;
	
	public PedidoTestDataBuilder() throws PesoNoAceptadoException, ParseException {
		this.id = 1L;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		this.fechaEntrega = calendar.getTime();
		Date fechaBonoInicial = calendar.getTime();
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

		this.productos = new ArrayList<>();
		this.productos.add(p1);
		this.productos.add(p2);
		this.productos.add(p3);
		this.productos.add(p4);

		this.citasPeluqueria = new ArrayList<>();
		this.citasPeluqueria.add(c1);
		this.citasPeluqueria.add(c2);
		this.citasPeluqueria.add(c3);
		this.citasPeluqueria.add(c4);

		this.bonoDescuento = Mockito.mock(BonoDescuento.class);
		Mockito.when(this.bonoDescuento.getDescuento()).thenReturn(0.1f);
		Mockito.when(this.bonoDescuento.getInicioVigencia()).thenReturn(fechaBonoInicial);
		Mockito.when(this.bonoDescuento.getFinVigencia()).thenReturn(fechaBonoFinal);
		this.currencyConverter = (Long usD) -> usD * 3500;
		this.currency = CurrencyType.COP;
	}

	public PedidoTestDataBuilder setProductos(List<Producto> productos) {
		this.productos = productos;
		return this;
	}

	public PedidoTestDataBuilder setCitasPeluqueria(List<CitaPeluqueria> citasPeluqueria) {
		this.citasPeluqueria = citasPeluqueria;
		return this;
	}

	public PedidoTestDataBuilder setBonoDescuento(BonoDescuento bonoDescuento) {
		this.bonoDescuento = bonoDescuento;
		return this;
	}

	public PedidoTestDataBuilder setCostoTotal(Long costoTotal) {
		this.costoTotal = costoTotal;
		return this;
	}

	public PedidoTestDataBuilder setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public PedidoTestDataBuilder setCurrency(CurrencyType currency) {
		this.currency = currency;
		return this;
	}

	public PedidoTestDataBuilder setCurrencyConverter(CurrencyConverterInterface currencyConverter) {
		this.currencyConverter = currencyConverter;
		return this;
	}

	public PedidoTestDataBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public Pedido build() throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
		return new Pedido(
				this.id,
				this.productos,
				this.citasPeluqueria,
				this.bonoDescuento,
				this.fechaEntrega,
				this.currency,
				this.costoTotal,
				this.currencyConverter);
	}
}
