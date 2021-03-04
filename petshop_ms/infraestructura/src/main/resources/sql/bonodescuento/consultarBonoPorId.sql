select
    id,
    codigo,
    inicioVigencia,
    finVigencia,
    descuento
from
    bonodescuento
where
    id = :id