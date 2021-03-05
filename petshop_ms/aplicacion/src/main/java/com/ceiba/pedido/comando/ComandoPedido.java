package com.ceiba.pedido.comando;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ComandoPedido {
    private Long id;
    private List<Long> productos;
    private List<ComandoCitaPeluqueria> citasPeluqueria;
    private Long bonoDescuento;
    private Date fechaEntrega;
    private String tipoMoneda;

    public ComandoPedido(Long id, List<Long> productos, List<ComandoCitaPeluqueria> citasPeluqueria, Long bonoDescuento,
            Date fechaEntrega, String tipoMoneda) {
        this.id = id;
        if (Objects.isNull(citasPeluqueria)) {
            this.citasPeluqueria = new ArrayList<>();
        } else {
            this.citasPeluqueria = citasPeluqueria;
        }

        if (Objects.isNull(productos)) {
            this.productos = new ArrayList<>();
        } else {
            this.productos = productos;
        }
        this.bonoDescuento = bonoDescuento;
        this.fechaEntrega = fechaEntrega;
        this.tipoMoneda = tipoMoneda;
    }

    public Long getId() {
        return id;
    }

    public List<Long> getProductos() {
        if (Objects.isNull(productos)) {
            return new ArrayList<>();
        } else {
            return productos;
        }
    }

    public List<ComandoCitaPeluqueria> getCitasPeluqueria() {
        if (Objects.isNull(citasPeluqueria)) {
            return new ArrayList<>();
        } else {
            return citasPeluqueria;
        }
    }

    public Long getBonoDescuento() {
        return bonoDescuento;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }
}
