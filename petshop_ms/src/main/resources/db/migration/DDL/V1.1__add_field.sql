ALTER TABLE
    factura
ADD
    fechaEntrega DATETIME(6) NULL;

ALTER TABLE
    producto
MODIFY
    COLUMN caracteristicas TEXT NOT NULL;