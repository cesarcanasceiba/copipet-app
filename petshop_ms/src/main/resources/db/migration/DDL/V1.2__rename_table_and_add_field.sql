RENAME
TABLE factura TO pedido;
ALTER TABLE pedido ADD fechaEntrega DATETIME(6) NULL;