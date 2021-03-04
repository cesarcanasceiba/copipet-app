package com.ceiba.pedido.adaptador.repositorio.mysql;

public class MapeoInsertarAsociacionCitaPedidoMysql {
    private Long factura_id;
    private Long citapeluqueria_id;

    public MapeoInsertarAsociacionCitaPedidoMysql(Long factura_id, Long citapeluqueria_id) {
        this.factura_id = factura_id;
        this.citapeluqueria_id = citapeluqueria_id;
    }

	public Long getFacturaId() {
		return factura_id;
	}

	public Long getCitapeluqueriaId() {
		return citapeluqueria_id;
	}
}
