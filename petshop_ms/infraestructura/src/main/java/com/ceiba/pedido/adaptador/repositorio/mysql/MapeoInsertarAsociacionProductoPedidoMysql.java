package com.ceiba.pedido.adaptador.repositorio.mysql;

public class MapeoInsertarAsociacionProductoPedidoMysql {
    private Long factura_id;
    private Long producto_id;

    public MapeoInsertarAsociacionProductoPedidoMysql(Long factura_id, Long producto_id) {
        this.factura_id = factura_id;
        this.producto_id = producto_id;
    }

	public Long getFactura_id() {
		return factura_id;
	}

	public Long getProducto_id() {
		return producto_id;
	}

}
