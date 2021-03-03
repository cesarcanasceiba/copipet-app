package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class DtoUsuario {
	private long id;
	@NonNull
	private String nombreUsuario;
	@NonNull
	private String direccion;
	@NonNull
	private String telefono;
	private boolean aceptaTerminos;
	@NonNull
	private Long ciudad;
	private Long tipoMascota;
}
