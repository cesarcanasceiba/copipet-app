package com.ceiba.producto.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.producto.testdatabuilder.CategoriaProductoTestDataBuilder;
import com.ceiba.producto.testdatabuilder.MarcaProductoTestDataBuilder;
import com.ceiba.producto.testdatabuilder.ProductoTestDataBuilder;

class ProductoTest {

	@Test
	void idNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setId(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void id() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setId(3L);
		assertEquals(3L, prodBuilder.build().getId());
	}

	@Test
	void nombreNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setNombre(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void nombre() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setNombre("nombre 1").setId(3L);
		assertEquals("nombre 1", prodBuilder.build().getNombre());
	}

	@Test
	void marcaNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setMarca(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void marca() {
		MarcaProducto marca = new MarcaProductoTestDataBuilder().setId(10L).build();
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setMarca(marca).setId(3L);
		assertEquals(10L, prodBuilder.build().getMarca().getId());
	}

	@Test
	void categoriaNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCategoriaProducto(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void categoria() {
		CategoriaProducto categoria = new CategoriaProductoTestDataBuilder().setId(10L).build();
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCategoriaProducto(categoria).setId(3L);
		assertEquals(10L, prodBuilder.build().getCategoriaProducto().getId());
	}

	@Test
	void precioNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPrecio(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void precio() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPrecio(100L).setId(3L);
		assertEquals(100L, prodBuilder.build().getPrecio());
	}

	@Test
	void presentacionNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPresentacion(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void presentacion() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setPresentacion("10");
		assertEquals("10", prodBuilder.build().getPresentacion());
	}

	@Test
	void fotoNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setFoto(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void foto() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setFoto("foto");
		assertEquals("foto", prodBuilder.build().getFoto());
	}

	@Test
	void descripcionNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setDescripcion(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void descripcion() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setDescripcion("descripcion");
		assertEquals("descripcion", prodBuilder.build().getDescripcion());
	}

	@Test
	void caracteristicasNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCaracteristicas(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void caracteristicas() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCaracteristicas("caracteristicas");
		assertEquals("caracteristicas", prodBuilder.build().getCaracteristicas());
	}

	@Test
	void beneficiosNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setBeneficios(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void beneficios() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setBeneficios("beneficios");
		assertEquals("beneficios", prodBuilder.build().getBeneficios());
	}

	@Test
	void codigoNulo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCodigoProducto(null);
		assertThrows(NullPointerException.class, () -> prodBuilder.build(), "Validación de nulos");
	}

	@Test
	void codigo() {
		ProductoTestDataBuilder prodBuilder = new ProductoTestDataBuilder().setCodigoProducto("codigo");
		assertEquals("codigo", prodBuilder.build().getCodigoProducto());
	}
}
