package com.ceiba.ciudad.modelo.entidad;

import lombok.Getter;

@Getter
public class Ciudad {
    public Ciudad(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	private Long id;
    private String nombre;
    
    public boolean equals(Ciudad other) {
    	return this.id.equals(other.getId());
    }
}
