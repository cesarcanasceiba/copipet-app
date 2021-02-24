package com.ceiba.citapeluqueria.modelo.entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.testdatabuilder.CitaPeluqueriaTestDataBuilder;

class CitaPeluqueriaTest {

	@Test
	void fechaInicioCitaInvalida() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, -1);
		
		assertThrows(FechaInicioCitaInvalidaException.class,
				()->new CitaPeluqueriaTestDataBuilder().setFechaInicio(cal.getTime()).build());
	}
	
	@Test
	void citaConPesoInferiorAlMinimo() {
		assertThrows(PesoNoAceptadoException.class,
				()->new CitaPeluqueriaTestDataBuilder().setPesoMascota(1.2F).build());
	}
	
	@Test
	void citaConPesoSuperiorAlMaximo() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, -1);

		assertThrows(PesoNoAceptadoException.class,
				()->new CitaPeluqueriaTestDataBuilder().setPesoMascota(78F).build());
	}
	
	@Test
	void asignacionCorrectaFechaFinal() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().setPesoMascota(3F).build();
		Calendar cl = Calendar.getInstance();
		cl.setTime(cita.getFechaInicio());
		cl.add(Calendar.MINUTE, 30);
		Date fechaFinal = cl.getTime();

		assertEquals(
				0,
				cita.getFechaFinal().compareTo(fechaFinal),
				"No se asigna la fecha final correctamente");
	}
	
	@ParameterizedTest
	@CsvSource({
        "2, 35000",
        "6, 50000",
        "15, 65000",
        "21, 90000",
        "55, 120000",
    })
	void calcularPrecioRango(float pesoMascota, Long precio) throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().setPesoMascota(pesoMascota).build();
        
		assertEquals(
				0,
				cita.calcularPrecio().compareTo(precio),
				"El precio se calcul� incorrectamente");
	}
	
	@Test
	void recuperarPrecio() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().setPesoMascota(3F).build();
		assertEquals(0, cita.getCostoCita().compareTo(35000L), "No retorna el costo de la cita apropiado");
		
	}
	
	@Test
	void evaluarNuloMascotaException() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		assertThrows(NullPointerException.class, ()->new CitaPeluqueriaTestDataBuilder().setPesoMascota(null).build());	
	}
	
	@Test
	void evaluarNuloFechaInicioException() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		assertThrows(NullPointerException.class, ()->new CitaPeluqueriaTestDataBuilder().setFechaInicio(null).build());	
	}
	
	@Test
	void evaluarNuloServiciosException() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		assertThrows(NullPointerException.class, ()->new CitaPeluqueriaTestDataBuilder().setServicios(null).build());	
	}
}
