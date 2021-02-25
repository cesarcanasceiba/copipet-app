package com.ceiba.pedido.testdatabuilder;

import com.ceiba.TestDataBuilderInterface;
import com.ceiba.producto.modelo.dto.ProductoDetalleDTO;

public class ProductoDetalleTestDataBuilder implements TestDataBuilderInterface<ProductoDetalleDTO>{

	private Long id;
    private String nombre;
    private String marca;
    private Long precio;
    private String presentacion;
    private String foto;
    private String descripcion;
    private String caracteristicas;
    private String beneficios;
    private String codigoProducto;
    private String categoriaProducto;
    
    public ProductoDetalleTestDataBuilder() {
    	id= 1L;
        nombre = "nombre1";
        marca = "marca1";
        precio= 1L;
        presentacion = "Presentacion";
        foto = "foto";
        descripcion = "descripcion";
        caracteristicas = "caracteristicas";
        beneficios = "beneficios";
        codigoProducto = "codigo";
        categoriaProducto = "categoria";
    }
	
	public ProductoDetalleTestDataBuilder setId(Long id) {
		this.id = id;
	    return this;
	}

	public ProductoDetalleTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoDetalleTestDataBuilder setMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public ProductoDetalleTestDataBuilder setPrecio(Long precio) {
		this.precio = precio;
		return this;
	}

	public ProductoDetalleTestDataBuilder setPresentacion(String presentacion) {
		this.presentacion = presentacion;
		return this;
	}

	public ProductoDetalleTestDataBuilder setFoto(String foto) {
		this.foto = foto;
		return this;
	}

	public ProductoDetalleTestDataBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ProductoDetalleTestDataBuilder setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
		return this;
	}

	public ProductoDetalleTestDataBuilder setBeneficios(String beneficios) {
		this.beneficios = beneficios;
		return this;
	}

	public ProductoDetalleTestDataBuilder setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
		return this;
	}

	public ProductoDetalleTestDataBuilder setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
		return this;
	}

	@Override
	public ProductoDetalleDTO build() {
		return new ProductoDetalleDTO(id, nombre, marca, precio, presentacion, foto, descripcion, caracteristicas, beneficios, codigoProducto, categoriaProducto);
	}

}
