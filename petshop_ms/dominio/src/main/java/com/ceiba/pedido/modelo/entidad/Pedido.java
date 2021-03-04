package com.ceiba.pedido.modelo.entidad;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.*;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.currency.TipoMoneda;
import com.ceiba.pedido.currency.converter.ConversorMonedaInterface;
import com.ceiba.pedido.exception.ConverterNoImplementadoException;
import com.ceiba.pedido.exception.FechaDePedidoInvalidaException;
import com.ceiba.pedido.exception.PedidoConListasVaciasException;
import com.ceiba.pedido.exception.PedidoSinElementosException;
import com.ceiba.producto.modelo.entidad.Producto;

@Getter
public class Pedido {
	private Long id;
	private List<Producto> productos;
	private List<CitaPeluqueria> citasPeluqueria;
	private BonoDescuento bonoDescuento;
	private Date fechaEntrega;
	private TipoMoneda tipoMoneda;
	private ConversorMonedaInterface conversorMoneda;
	private Long costoTotal;

	public Pedido(Long id, @NonNull List<Producto> productos, @NonNull List<CitaPeluqueria> citasPeluqueria,
			BonoDescuento bonoDescuento, @NonNull Date fechaEntrega, @NonNull TipoMoneda tipoMoneda,
			ConversorMonedaInterface conversorMoneda) throws PedidoConListasVaciasException,
			PedidoSinElementosException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
		this.validarListasCitasProductosNoVacios(citasPeluqueria, productos);
		this.validarFechaPedido(fechaEntrega);
		this.id = id;
		this.productos = Collections.unmodifiableList(productos);
		this.citasPeluqueria = Collections.unmodifiableList(citasPeluqueria);
		this.bonoDescuento = bonoDescuento;
		this.fechaEntrega = new Date(fechaEntrega.getTime());
		this.costoTotal = this.definirCostoTotal(productos, citasPeluqueria, tipoMoneda, conversorMoneda);
	}

	public Date getFechaEntrega() {
		return new Date(this.fechaEntrega.getTime());
	}

	/**
	 * Calcula el precio del pedido en funci�n de la lista de productos y citas de
	 * peluquer�a
	 * 
	 * @param productos
	 * @param citas
	 * @return
	 * @throws PedidoConListasVaciasException
	 */
	private Long getCostoTotalFromProductosCitas(List<Producto> productos, List<CitaPeluqueria> citas)
			throws PedidoConListasVaciasException {
		Long costoCalculado = productos.stream().map(Producto::getPrecio).reduce((precio, acc) -> precio + acc)
				.map(precio -> {
					if (Pedido.this.esBonoCanjeable(this.bonoDescuento)) {
						return (long) (precio * (1 - Pedido.this.bonoDescuento.getDescuento()));
					} else {
						return precio;
					}
				}).orElse(0L);

		costoCalculado = costoCalculado
				+ citas.stream().map(CitaPeluqueria::getCostoCita).reduce((precio, acc) -> precio + acc).orElse(0L);
		return costoCalculado;
	}

	/**
	 * Verifica si el bono es v�lido
	 * 
	 * @param bono
	 * @return
	 */
	private boolean esBonoCanjeable(BonoDescuento bono) {
		if (bono != null) {
			Date fechaInicial = bono.getInicioVigencia();
			Date fechaFinal = bono.getFinVigencia();
			Date current = new Date();
			return fechaInicial.compareTo(current) <= 0 && 0 <= fechaFinal.compareTo(current)
					&& 0 < bono.getDescuento();
		} else {
			return false;
		}
	}

	/**
	 * Valida si la fecha de entrega es valida
	 * 
	 * @param fechaEntrega
	 * @throws FechaDePedidoInvalidaException
	 */
	private void validarFechaPedido(Date fechaEntrega) throws FechaDePedidoInvalidaException {
		Date current = new Date();
		if (current.compareTo(fechaEntrega) > 0) {
			throw new FechaDePedidoInvalidaException();
		}

	}

	/**
	 * Valida si las listas de productos y citas son no vac�os
	 * 
	 * @param citas
	 * @param productos
	 * @throws PedidoConListasVaciasException
	 * @throws Exception
	 */
	private void validarListasCitasProductosNoVacios(List<CitaPeluqueria> citas, List<Producto> productos)
			throws PedidoConListasVaciasException {
		if (citas.isEmpty() && productos.isEmpty()) {
			throw new PedidoConListasVaciasException();
		}
	}

	/**
	 * Realiza la conversi�n de moneda en caso de que el pago llegue en dolares
	 * 
	 * @param costoTotal
	 * @param currency
	 * @param currencyConverter
	 * @return Valor de la compra en pesos colombianos
	 * @throws ConverterNoImplementadoException
	 * @throws PedidoConListasVaciasException
	 */
	private Long definirCostoTotal(List<Producto> productos, List<CitaPeluqueria> citasPeluqueria, TipoMoneda currency,
			ConversorMonedaInterface currencyConverter)
			throws ConverterNoImplementadoException, PedidoConListasVaciasException {
		Long costo = this.getCostoTotalFromProductosCitas(productos, citasPeluqueria);
		if (currency == TipoMoneda.USD) {
			if (currencyConverter == null) {
				throw new ConverterNoImplementadoException();
			} else {
				costo = currencyConverter.fromCopToUsD(costo);
			}
		}
		return costo;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (this.getClass() != other.getClass()) {
			return false;
		}
		Pedido instance = (Pedido) other;
		return this.id.equals(instance.id);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
