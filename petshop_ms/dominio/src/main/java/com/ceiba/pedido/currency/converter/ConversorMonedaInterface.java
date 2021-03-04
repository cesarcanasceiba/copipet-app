package com.ceiba.pedido.currency.converter;

@FunctionalInterface
public interface ConversorMonedaInterface {

	Long fromCopToUsD(Long cop);
}
