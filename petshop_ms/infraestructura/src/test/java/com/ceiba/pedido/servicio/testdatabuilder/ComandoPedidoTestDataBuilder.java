package com.ceiba.pedido.servicio.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.testdatabuilder.ComandoCitaPeluqueriaTestDataBuilder;
import com.ceiba.pedido.comando.ComandoPedido;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private List<Long> productos;
    private List<ComandoCitaPeluqueria> citasPeluqueria;
    private Long bonoDescuento;
    private Date fechaEntrega;
    private String tipoMoneda;

    public ComandoPedidoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPedidoTestDataBuilder setProductos(List<Long> productos) {
        this.productos = productos;
        return this;
    }

    public ComandoPedidoTestDataBuilder setCitasPeluqueria(List<ComandoCitaPeluqueria> citasPeluqueria) {
        this.citasPeluqueria = citasPeluqueria;
        return this;
    }

    public ComandoPedidoTestDataBuilder setBonoDescuento(Long bonoDescuento) {
        this.bonoDescuento = bonoDescuento;
        return this;
    }

    public ComandoPedidoTestDataBuilder setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public ComandoPedidoTestDataBuilder setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, productos, citasPeluqueria, bonoDescuento, fechaEntrega, tipoMoneda);
    }

    public ComandoPedidoTestDataBuilder() throws ParseException {
        this.id = 1L;
        this.productos = Arrays.asList(1L, 2L, 10L, 20L, 21L, 22L);
        this.citasPeluqueria = Arrays.asList(new ComandoCitaPeluqueriaTestDataBuilder().setId(null).build());
        this.bonoDescuento = 1L;
        Double anio = Math.floor(Math.random() * 50 + 22);
        Double mes = Math.floor(Math.random() * 2 + 10);
        Double dia = Math.floor(Math.random() * 18 + 10);
        String fechaIso = "20" + anio.intValue() + "-" + mes.intValue() + "-" + dia.intValue() + "T14:12:22.354Z";
        this.fechaEntrega = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(fechaIso);
        this.tipoMoneda = "COP";
    }
}
