package com.ceiba.producto.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.producto.testdatabuilder.MarcaProductoTestDataBuilder;
import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

class MarcaProductoTest {

	@Test
	void test() {
		MarcaProductoTestDataBuilder marcaBuilder = new MarcaProductoTestDataBuilder().setNombre(null);
		assertThrows(
				NullPointerException.class,
				()-> marcaBuilder.build(),
				"Validación de nulos");
	}

}
