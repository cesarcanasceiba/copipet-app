select pr.id, pr.nombre, ma.nombre as marca, pr.precio, pr.presentacion, pr.foto from producto as pr inner join marcaproducto as ma on(pr.marca_id=ma.id) where pr.categoria_producto_id=:categoria_id;