package com.ceiba.producto.modelo.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.pedido.testdatabuilder.ProductoDetalleTestDataBuilder;

class ProductoDetalleDTOTest {

	@Test
	void validarExpecionNuloId() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setId(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloNombre() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setNombre(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloMarca() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setMarca(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloPrecio() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setPrecio(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloPresentacion() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setPresentacion(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloFoto() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setFoto(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloDescripcion() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setDescripcion(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloCaracteristicas() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setCaracteristicas(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloBeneficios() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setBeneficios(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloCodigoProducto() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setCodigoProducto(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarExpecionNuloCategoriaProducto() {
		ProductoDetalleTestDataBuilder pr = new ProductoDetalleTestDataBuilder()
				.setCategoriaProducto(null);
		assertThrows(NullPointerException.class, ()->pr.build());
	}
	
	@Test
	void validarCrearInstancia() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr);
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
	
	@Test
	void getId() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getId());
	}
	
	@Test
	void getPrecio() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getPrecio());
	}
	
	@Test
	void getNombre() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getNombre());
	}
	
	@Test
	void getPresentacion() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getPresentacion());
	}
	
	@Test
	void getFoto() {
		ProductoDetalleDTO pr = new ProductoDetalleTestDataBuilder().build();
		assertNotNull(pr.getFoto());
	}
}
