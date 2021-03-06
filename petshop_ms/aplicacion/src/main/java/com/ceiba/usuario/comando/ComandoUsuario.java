package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario {

    private Long id;
    private String nombre;
    private Long ciudad;
    private Long tipoMascota;
    private String password;
    private String direccion;
    private String telefono;
    private boolean aceptaTerminos;
}
