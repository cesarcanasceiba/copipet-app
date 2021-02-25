package com.ceiba.producto.modelo.entidad;

import lombok.*;

@Getter
@AllArgsConstructor
public class CategoriaProducto {
    @NonNull private Long id;
    @NonNull private String nombre;
}
