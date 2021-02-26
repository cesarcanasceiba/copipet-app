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

    @Override
    public int hashCode() {
      return super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
    	if(other == null) {
    		return false;
    	}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		Ciudad instance = (Ciudad) other;    	
    	return this.id.equals(instance.getId());
    }
}
