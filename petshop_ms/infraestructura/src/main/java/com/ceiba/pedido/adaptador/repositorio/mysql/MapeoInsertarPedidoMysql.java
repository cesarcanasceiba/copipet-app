package com.ceiba.pedido.adaptador.repositorio.mysql;

import java.util.Date;

public class MapeoInsertarPedidoMysql {
    private Long costoTotal;
    private Long bonoDescuento_id;
    private Date fechaEntrega;

    public MapeoInsertarPedidoMysql(Long costoTotal, Long bonoDescuento_id, Date fechaEntrega) {
        this.costoTotal = costoTotal;
        this.bonoDescuento_id = bonoDescuento_id;
        this.fechaEntrega = fechaEntrega;
    }
}
