package com.ceiba.pedido.currency;

public enum CurrencyType {
	COP("Pesos colombianos"),
	USD( "Dolar estadounidense");
	
	private String definicion;
	
	private CurrencyType(String definicion) {
		
		this.definicion = definicion;
	}

	public String getDefinicion() {
		return definicion;
	}
}
