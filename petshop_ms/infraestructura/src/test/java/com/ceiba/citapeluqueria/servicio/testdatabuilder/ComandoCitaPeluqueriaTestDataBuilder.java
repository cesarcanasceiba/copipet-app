package com.ceiba.citapeluqueria.servicio.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;

public class ComandoCitaPeluqueriaTestDataBuilder {
    private Long id;
    private Long peluquero;
    private List<Long> servicios;
    private Date fechaInicio;
    private Long usuario;
    private String fotoMascota;
    private Float pesoMascota;
    private Long costoCita;
    private Long ciudad;

    public ComandoCitaPeluqueriaTestDataBuilder() throws ParseException {
        this.id = 1L;
        this.peluquero = 1L;
        this.servicios = Arrays.asList(1L, 3L, 4L, 5L, 6L);
        Double anio = Math.floor(Math.random() * 50 + 22);
        Double mes = Math.floor(Math.random() * 2 + 10);
        Double dia = Math.floor(Math.random() * 18 + 10);
        String fechaIso = "20" + anio.intValue() + "-" + mes.intValue() + "-" + dia.intValue() + "T14:12:22.354Z";
        this.fechaInicio = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(fechaIso);
        this.usuario = 1L;
        this.fotoMascota = "https://i.pinimg.com/originals/63/67/0b/63670bc6d54aed140e1358c97fddb024.jpg";
        this.pesoMascota = 33.5F;
        this.ciudad = 10L;
    }

    public ComandoCitaPeluqueria build() {
        return new ComandoCitaPeluqueria(id, peluquero, servicios, fechaInicio, usuario, fotoMascota, pesoMascota,
                costoCita, ciudad);
    }

    public ComandoCitaPeluqueriaTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setPeluquero(Long peluquero) {
        this.peluquero = peluquero;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setServicios(List<Long> servicios) {
        this.servicios = servicios;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setUsuario(Long usuario) {
        this.usuario = usuario;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setFotoMascota(String fotoMascota) {
        this.fotoMascota = fotoMascota;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setPesoMascota(Float pesoMascota) {
        this.pesoMascota = pesoMascota;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setCostoCita(Long costoCita) {
        this.costoCita = costoCita;
        return this;
    }

    public ComandoCitaPeluqueriaTestDataBuilder setCiudad(Long ciudad) {
        this.ciudad = ciudad;
        return this;
    }
}
