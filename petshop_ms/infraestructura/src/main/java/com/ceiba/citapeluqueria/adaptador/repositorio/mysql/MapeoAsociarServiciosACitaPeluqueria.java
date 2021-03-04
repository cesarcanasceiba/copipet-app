package com.ceiba.citapeluqueria.adaptador.repositorio.mysql;

public class MapeoAsociarServiciosACitaPeluqueria {
    private Long citapeluqueria_id;
    private Long serviciopeluqueria_id;

    public MapeoAsociarServiciosACitaPeluqueria(Long citapeluqueria_id, Long serviciopeluqueria_id) {
        this.citapeluqueria_id = citapeluqueria_id;
        this.serviciopeluqueria_id = serviciopeluqueria_id;
    }

	public Long getCitapeluqueriaId() {
		return citapeluqueria_id;
	}

	public Long getServiciopeluqueriaId() {
		return serviciopeluqueria_id;
	}
}
