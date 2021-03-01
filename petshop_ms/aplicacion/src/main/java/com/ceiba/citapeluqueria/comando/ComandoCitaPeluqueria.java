package com.ceiba.citapeluqueria.comando;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCitaPeluqueria {
    private Long id;
    private Long peluquero;
    private List<Long> servicios;
    private Date fechaInicio;
    private Long usuario;
    private String fotoMascota;
    private Float pesoMascota;
    private Long costoCita;
    private Long ciudad;
}
