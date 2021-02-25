package com.ceiba.producto.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.pedido.testdatabuilder.ProductoDetalleTestDataBuilder;

class ProductoDetalleDTOTest {

	@Test
	void validarExpecionNulo() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder().setBeneficios(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void beneficios() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getBeneficios());
	}
	
	@Test
	void getCaracteristicas() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getCaracteristicas());
	}
	
	@Test
	void getCategoriaProducto() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getCategoriaProducto());
	}
	
	@Test
	void getCodigoProducto() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getCodigoProducto());
	}
	
	@Test
	void getDescripcion() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getDescripcion());
	}
	
	@Test
	void getMarca() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getMarca());
	}
}
