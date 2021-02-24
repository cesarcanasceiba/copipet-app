package com.ceiba.producto.puerto.dao;

import java.util.List;

import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;
import com.ceiba.producto.modelo.dto.ProductoResumenDTO;
import com.ceiba.producto.modelo.entidad.CategoriaProducto;

public interface ProductoDao {

	/**
	 * Recupera un listado de productos resumen
	 * @return
	 */
	List<ProductoResumenDTO> listaProductosResumen();
	
	/**
	 * Lista de productos filtrado por categor�a
	 * @param categoria
	 * @return
	 */
	List<ProductoResumenDTO> listaProductosPorCategoria(CategoriaProducto categoria);
	
	/**
	 * Recupera la informaci�n de detalle de un producto
	 * @param id
	 * @return
	 */
	ProductoDetalleDTO verDetalleProducto(Long id);
}
