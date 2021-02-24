package com.ceiba.pedido.modelo.entidad;

import java.util.Date;
import java.util.List;
import lombok.*;

import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.pedido.currency.CurrencyType;
import com.ceiba.pedido.currency.converter.CurrencyConverterInterface;
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
    private Long costoTotal;
    private Date fechaEntrega;
    private CurrencyType currency;
	private CurrencyConverterInterface currencyConverter;
	public Pedido(Long id, List<Producto> productos, List<CitaPeluqueria> citasPeluqueria, BonoDescuento bonoDescuento,
			Date fechaEntrega, CurrencyType currency, Long costoTotal, CurrencyConverterInterface currencyConverter) throws PedidoSinElementosException, PedidoConListasVaciasException, FechaDePedidoInvalidaException, ConverterNoImplementadoException {
		this(id, productos, citasPeluqueria, costoTotal, bonoDescuento, fechaEntrega);
		this.currency = currency;
		this.currencyConverter = currencyConverter;
		this.costoTotal = this.definirCostoTotal(costoTotal, currency, currencyConverter);
	}
	
	public Pedido(Long id, List<Producto> productos, List<CitaPeluqueria> citasPeluqueria, Long costoTotal, BonoDescuento bonoDescuento, Date fechaEntrega) throws PedidoSinElementosException, FechaDePedidoInvalidaException, PedidoConListasVaciasException {
		
		this.validarCitasProductosPedido(citasPeluqueria, productos);
		this.validarListasCitasProductosNoVacios(citasPeluqueria, productos);
		this.validarFechaPedido(fechaEntrega);
		this.id = id;
		this.productos = productos;
		this.citasPeluqueria = citasPeluqueria;
		this.bonoDescuento = bonoDescuento;
		this.fechaEntrega = fechaEntrega;
		this.costoTotal = costoTotal;
	}
	
	public Pedido(List<Producto> productos, List<CitaPeluqueria> citasPeluqueria, BonoDescuento bonoDescuento, Date fechaEntrega) throws PedidoConListasVaciasException {
		this.productos = productos;
		this.citasPeluqueria = citasPeluqueria;
		this.bonoDescuento = bonoDescuento;
		this.fechaEntrega = fechaEntrega;
		this.costoTotal = this.getCostoTotalFromProductosCitas(productos, citasPeluqueria);
	}

	/**
	 * Calcula el precio del pedido en función de la lista de productos y citas de peluquería
	 * @param productos
	 * @param citas
	 * @return
	 * @throws PedidoConListasVaciasException
	 */
    private Long getCostoTotalFromProductosCitas(List<Producto> productos, List<CitaPeluqueria> citas) throws PedidoConListasVaciasException {
		Long costoCalculado = productos
				.stream()
				.map(Producto::getPrecio)
				.reduce((precio, acc)->precio + acc)
				.map(precio->{
					if(Pedido.this.esBonoCanjeable(this.bonoDescuento)) {
						return (precio * (int)((1 - this.bonoDescuento.getDescuento()) * 100))/100;
					}else {
						return precio;
					}
				})
				.orElseThrow(PedidoConListasVaciasException::new);

		costoCalculado = costoCalculado + citas
				.stream()
				.map(t -> {
					try {
						return t.calcularPrecio();
					} catch (PesoNoAceptadoException e) {
						return null;
					}
				})
				.reduce((precio, acc)->precio + acc)
				.orElseThrow(PedidoConListasVaciasException::new);
		
		return costoCalculado;
	}
    
    /**
     * Verifica si el bono es válido
     * @param bono
     * @return
     */
    private boolean esBonoCanjeable(BonoDescuento bono) {
    	if(bonoDescuento != null) {
    		Date fechaInicial = bono.getInicioVigencia();
    		Date fechaFinal = bono.getFinVigencia();
    		Date current = new Date();
    		return fechaInicial.compareTo(current) < 0 && 0 < fechaFinal.compareTo(current);
    	}else {
    		return false;
    	}
    }

	/**
     * Valida si la fecha de entrega es valida
     * @param fechaEntrega
     * @throws FechaDePedidoInvalidaException
     */
	private void validarFechaPedido(Date fechaEntrega) throws FechaDePedidoInvalidaException {
		Date current = new Date();
		if(current.compareTo(fechaEntrega) > 0) throw new FechaDePedidoInvalidaException();
		
	}


	/*
	 * Valida si las el pedido creado tiene citas y productos asociados
	 */
	private void validarCitasProductosPedido(List<CitaPeluqueria> citas, List<Producto> productos) throws PedidoSinElementosException  {
		if(citas == null && productos == null) throw new PedidoSinElementosException();
	}
	
	
	/**
	 * Valida si las listas de productos y citas son no vacíos
	 * @param citas
	 * @param productos
	 * @throws PedidoConListasVaciasException 
	 * @throws Exception
	 */
	private void validarListasCitasProductosNoVacios(List<CitaPeluqueria> citas, List<Producto> productos) throws PedidoConListasVaciasException  {
		if(citas !=null && productos != null && citas.isEmpty() && productos.isEmpty()) {
			throw new PedidoConListasVaciasException();	
		}
		
		
	}
	
	/**
	 * Realiza la conversión de moneda en caso de que el pago llegue en dolares
	 * @param costoTotal
	 * @param currency
	 * @param currencyConverter
	 * @return Valor de la compra en pesos colombianos
	 * @throws ConverterNoImplementadoException 
	 */
	private Long definirCostoTotal(Long costoTotal, CurrencyType currency, CurrencyConverterInterface currencyConverter) throws ConverterNoImplementadoException {
		Long costo = costoTotal;
		if(currency == CurrencyType.USD) {
			if(currencyConverter == null) {
				throw new ConverterNoImplementadoException();
			}else{
				costo = currencyConverter.fromUsDToCop(costoTotal);	
			}
    	}
		return costo;
	}
	
	public boolean equals(Pedido other) {
		return this.id.equals(other.id);
	}
}
