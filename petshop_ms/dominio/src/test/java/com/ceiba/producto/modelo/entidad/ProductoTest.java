package com.ceiba.producto.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

class ProductoTest {

	@Test
	void idNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setId(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void nombreNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setNombre(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void marcaNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setMarca(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void categoriaNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCategoriaProducto(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void precioNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPrecio(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void presentacionNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPresentacion(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void fotoNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setFoto(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void descripcionNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setDescripcion(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void caracteristicasNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCaracteristicas(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void beneficiosNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setBeneficios(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
	
	@Test
	void codigoNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCodigoProducto(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
}
