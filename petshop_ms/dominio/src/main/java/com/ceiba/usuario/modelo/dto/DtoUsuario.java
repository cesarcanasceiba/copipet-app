package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoUsuario {
	private long id;
	@NonNull private String nombreUsuario;
	@NonNull private String clave;
	@NonNull private String direccion;
	@NonNull private String telefono;
	private boolean aceptaTerminos;
	@NonNull private String ciudad;
	 private long tipoMascota;
}
