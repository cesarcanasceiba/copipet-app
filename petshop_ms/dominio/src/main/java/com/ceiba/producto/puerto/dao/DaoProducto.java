package com.ceiba.producto.puerto.dao;

import java.util.List;

import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.modelo.entidad.Producto;

public interface DaoProducto {

	/**
	 * Recupera un listado de productos resumen
	 * 
	 * @return
	 */
	List<ProductoResumenDTO> listaProductosResumen();

	/**
	 * Lista de productos filtrado por categoría
	 * 
	 * @param categoria
	 * @return
	 */
	List<ProductoResumenDTO> listaProductosPorCategoria(CategoriaProducto categoria);

	/**
	 * Recupera la información de detalle de un producto
	 * 
	 * @param id
	 * @return
	 */
	ProductoDetalleDTO verDetalleProducto(Long id);

	/**
	 * Listado de productos seleccionados por id
	 * 
	 * @param listado listado de id de productos
	 * @return Listado de productos
	 */
	List<Producto> listaDeProductosPorId(List<Long> listado);

	List<Producto> listaDeProductosPorPedido(Long pedidoId);
}
