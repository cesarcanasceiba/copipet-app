select
    id,
    nombre,
    password,
    direccion,
    telefono,
    acepta_terminos,
    ciudad_id,
    tipo_mascota_id
from
    usuario
where
    id = :id