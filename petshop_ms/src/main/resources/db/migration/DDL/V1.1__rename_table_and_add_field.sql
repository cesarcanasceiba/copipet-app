RENAME TABLE petshop.factura TO petshop.pedido;
ALTER TABLE petshop.pedido ADD fechaEntrega DATETIME(6) NULL;