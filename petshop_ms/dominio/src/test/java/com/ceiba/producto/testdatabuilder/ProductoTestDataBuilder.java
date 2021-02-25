package com.ceiba.producto.testdatabuilder;

import com.ceiba.producto.modelo.entidad.CategoriaProducto;
import com.ceiba.producto.modelo.entidad.MarcaProducto;
import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {
    Long id;
    private String nombre;
    private MarcaProducto marca;
    private CategoriaProducto categoriaProducto;
    private Long precio;
    private String presentacion;
    private String foto;
    private String descripcion;
    private String caracteristicas;
    private String beneficios;
    private String codigoProducto;
    
    public ProductoTestDataBuilder() {
    	this.id = 1L;
        this.nombre = "nombre 1";
        this.marca = new MarcaProductoTestDataBuilder().build();
        this.categoriaProducto = new CategoriaProductoTestDataBuilder().build();
        this.precio = 0L;
        this.presentacion = "8Kg";
        this.foto = "https://conceptodefinicion.de/wp-content/uploads/2014/05/Imagen-2.jpg";
        this.descripcion = "descripción";
        this.caracteristicas = "caracteristicas";
        this.beneficios = "beneficios";
        this.codigoProducto = "SKU 1";
    }
	
	public ProductoTestDataBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public ProductoTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ProductoTestDataBuilder setMarca(MarcaProducto marca) {
		this.marca = marca;
		return this;
	}

	public ProductoTestDataBuilder setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
		return this;
	}

	public ProductoTestDataBuilder setPrecio(Long precio) {
		this.precio = precio;
		return this;
	}

	public ProductoTestDataBuilder setPresentacion(String presentacion) {
		this.presentacion = presentacion;
		return this;
	}

	public ProductoTestDataBuilder setFoto(String foto) {
		this.foto = foto;
		return this;
	}

	public ProductoTestDataBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;		
	}

	public ProductoTestDataBuilder setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
		return this;
	}

	public ProductoTestDataBuilder setBeneficios(String beneficios) {
		this.beneficios = beneficios;
		return this;
	}

	public ProductoTestDataBuilder setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
		return this;
	}

	public Producto build() {
		return new Producto(id, nombre, marca, categoriaProducto, precio, presentacion, foto, descripcion, caracteristicas, beneficios, codigoProducto);
	}
}
