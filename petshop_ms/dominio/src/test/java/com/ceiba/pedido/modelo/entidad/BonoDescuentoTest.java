package com.ceiba.pedido.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.pedido.exception.DescuentoFueraRangoException;
import com.ceiba.pedido.testdatabuilder.BonoDescuentoTestDataBuilder;

class BonoDescuentoTest {

	@Test
	void rangoDescuentoIncorrecto() {
		BonoDescuentoTestDataBuilder bono = new BonoDescuentoTestDataBuilder().setDescuento(1.1F);
		assertThrows(DescuentoFueraRangoException.class, () -> bono.build(), "Bono con rango de descuento incorrecto");

	}

	@Test
	void validarDescuentoNulo() {
		BonoDescuento bono = new BonoDescuentoTestDataBuilder().setDescuento(null).build();
		assertEquals(0F, bono.getDescuento());
	}

	@Test
	void validarDescuentoCero() {
		BonoDescuento bono = new BonoDescuentoTestDataBuilder().setId(0L).build();
		assertEquals(0F, bono.getDescuento());
	}

	@Test
	void bonoMenorO() {
		BonoDescuentoTestDataBuilder bono = new BonoDescuentoTestDataBuilder().setDescuento(-1F);
		assertThrows(DescuentoFueraRangoException.class, () -> bono.build(), "Bono con rango de descuento incorrecto");
	}

}
