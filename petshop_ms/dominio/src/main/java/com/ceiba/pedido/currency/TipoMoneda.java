package com.ceiba.pedido.currency;

public enum TipoMoneda {
	COP("Pesos colombianos"),
	USD( "Dolar estadounidense");
	
	private String definicion;
	
	private TipoMoneda(String definicion) {
		
		this.definicion = definicion;
	}

	public String getDefinicion() {
		return definicion;
	}
}
