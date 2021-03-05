package com.ceiba.pedido.exception;

public class PedidoConListasVaciasException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "El pedido tiene listas vacías para citas y productos";
	}

}
