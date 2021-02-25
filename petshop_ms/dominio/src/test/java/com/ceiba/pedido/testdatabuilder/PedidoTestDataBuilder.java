package com.ceiba.pedido.testdatabuilder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.mockito.Mockito;

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
import com.ceiba.pedido.modelo.entidad.BonoDescuento;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

public class PedidoTestDataBuilder {
    private List<Producto> productos;
    private List<CitaPeluqueria> citasPeluqueria;
    private BonoDescuento bonoDescuento;
    private Long costoTotal;
    private Date fechaEntrega;
    private TipoMoneda currency;
	private ConversorMonedaInterface currencyConverter;
	private long id;

	public PedidoTestDataBuilder() throws PesoNoAceptadoException, ParseException, FechaInicioCitaInvalidaException {
		this.id = 1L;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		this.fechaEntrega = calendar.getTime();

		Producto p1 = new ProductoTestDataBuilder().setPrecio(40L).build();
		Producto p2 = new ProductoTestDataBuilder().setPrecio(50L).build();
		Producto p3 = new ProductoTestDataBuilder().setPrecio(60L).build();
		Producto p4 = new ProductoTestDataBuilder().setPrecio(70L).build();

		this.productos = new ArrayList<>();
		this.productos.add(p1);
		this.productos.add(p2);
		this.productos.add(p3);
		this.productos.add(p4);

		CitaPeluqueria c1 = new CitaPeluqueriaTestDataBuilder().setPesoMascota(10F).build();
		CitaPeluqueria c2 = new CitaPeluqueriaTestDataBuilder().setPesoMascota(15F).build();
		CitaPeluqueria c3 = new CitaPeluqueriaTestDataBuilder().setPesoMascota(25F).build();
		CitaPeluqueria c4 = new CitaPeluqueriaTestDataBuilder().setPesoMascota(35F).build();

		this.citasPeluqueria = new ArrayList<>();
		this.citasPeluqueria.add(c1);
		this.citasPeluqueria.add(c2);
		this.citasPeluqueria.add(c3);
		this.citasPeluqueria.add(c4);

		this.bonoDescuento = new BonoDescuentoTestDataBuilder().build();

		this.currencyConverter = (Long usD) -> usD * 3500;
		this.currency = TipoMoneda.COP;
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

	public PedidoTestDataBuilder setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public PedidoTestDataBuilder setCurrency(TipoMoneda currency) {
		this.currency = currency;
		return this;
	}

	public PedidoTestDataBuilder setCurrencyConverter(ConversorMonedaInterface currencyConverter) {
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
				this.currencyConverter);
	}
}
