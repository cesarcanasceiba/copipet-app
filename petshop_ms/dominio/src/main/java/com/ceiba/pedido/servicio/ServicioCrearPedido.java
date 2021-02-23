package com.ceiba.pedido.servicio;

import com.ceiba.pedido.currency.converter.CurrencyConverterInterface;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioCrearPedido {
    private final RepositorioPedido repositorioPedido;
    
    public ServicioCrearPedido(RepositorioPedido respositorioPedido) {
    	this.repositorioPedido = respositorioPedido;
    }
    
    public Pedido ejecutar(Pedido pedido, CurrencyConverterInterface currencyConverter) {
    	
    	return this.repositorioPedido.crear(pedido);
    }
}
