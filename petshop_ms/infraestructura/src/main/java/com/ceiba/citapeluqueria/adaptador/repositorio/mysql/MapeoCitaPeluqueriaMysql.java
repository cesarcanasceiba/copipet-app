package com.ceiba.citapeluqueria.adaptador.repositorio.mysql;

import java.util.Date;

public class MapeoCitaPeluqueriaMysql {
    private Date hora_inicio;
    private Date hora_final;
    private String fotoMascota;
    private Float pesoMascota;
    private Long costoCita;
    private Long peluquero_id;
    private Long usuario_id;

    public MapeoCitaPeluqueriaMysql(Date hora_inicio, Date hora_final, String fotoMascota, Float pesoMascota,
            Long costoCita, Long peluquero_id, Long usuario_id) {
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.fotoMascota = fotoMascota;
        this.pesoMascota = pesoMascota;
        this.costoCita = costoCita;
        this.peluquero_id = peluquero_id;
        this.usuario_id = usuario_id;
    }

}