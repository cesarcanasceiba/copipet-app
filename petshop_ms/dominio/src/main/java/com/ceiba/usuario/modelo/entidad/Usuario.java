package com.ceiba.usuario.modelo.entidad;


import lombok.*;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.mascota.modelo.entidad.TipoMascota;

@Getter
@RequiredArgsConstructor
public class Usuario {

    private Long id;
    @NonNull String nombre;
    @NonNull private Ciudad ciudad;
    @NonNull private TipoMascota tipoMascota;
    @NonNull private String password;
    @NonNull private String direccion;
    @NonNull private String telefono;
    @NonNull private Boolean aceptaTerminos;
}
