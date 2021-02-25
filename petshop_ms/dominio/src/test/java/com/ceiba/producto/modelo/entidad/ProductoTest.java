package com.ceiba.producto.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

class ProductoTest {

	@Test
	void test() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setMarca(null);
		assertThrows(
				NullPointerException.class,
				()-> prodBuilder.build(),
				"Validación de nulos");
	}
}
