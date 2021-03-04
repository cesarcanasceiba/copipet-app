insert into
    usuario (
        nombre,
        password,
        direccion,
        telefono,
        acepta_terminos,
        ciudad_id,
        tipo_mascota_id
    )
values
    (
        'nombre prueba consulta',
        'password',
        'direccion',
        'telefono',
        1,
        1,
        1
    );

insert into
    bonodescuento (codigo, inicioVigencia, finVigencia, descuento)
values
    ('COD1', '2021-03-01', '2021-03-30', 0.1);