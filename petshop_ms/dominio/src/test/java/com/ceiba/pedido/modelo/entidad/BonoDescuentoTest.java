package com.ceiba.pedido.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ceiba.pedido.exception.DescuentoFueraRangoException;
import com.ceiba.pedido.testdatabuilder.BonoDescuentoTestDataBuilder;

class BonoDescuentoTest {

	@Test
	void rangoDescuentoIncorrecto() {
		BonoDescuentoTestDataBuilder bono = new BonoDescuentoTestDataBuilder().setDescuento(1.1F);
		assertThrows(DescuentoFueraRangoException.class, ()->bono.build(), "Bono con rango de descuento incorrecto");
		
	}

}
