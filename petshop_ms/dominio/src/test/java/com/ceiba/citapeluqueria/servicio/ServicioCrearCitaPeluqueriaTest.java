package com.ceiba.citapeluqueria.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.citapeluqueria.exception.CitasSimultaneasException;
import com.ceiba.citapeluqueria.exception.CiudadNoValidaParaCita;
import com.ceiba.citapeluqueria.exception.FechaInicioCitaInvalidaException;
import com.ceiba.citapeluqueria.exception.PesoNoAceptadoException;
import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.generadorciudad.GeneradorCiudadValidaCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.citapeluqueria.testdatabuilder.CitaPeluqueriaTestDataBuilder;
import com.ceiba.ciudad.modelo.entidad.Ciudad;

public class ServicioCrearCitaPeluqueriaTest {

	private static Long BOGOTA_ID = 1L;

	@Test
	public void excepcionGuardarEnCiudadDiferenteABogota()
			throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		Ciudad bogota = new Ciudad(BOGOTA_ID, "Bogota");
		GeneradorCiudadValidaCitaPeluqueria generadorBogota = () -> bogota;

		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().build();
		RepositorioCitaPeluqueria repositorio = Mockito.mock(RepositorioCitaPeluqueria.class);
		Mockito.when(repositorio.crear(cita)).thenReturn(cita);

		ServicioCrearCitaPeluqueria servicio = new ServicioCrearCitaPeluqueria(repositorio, generadorBogota);

		Ciudad ciudadInvalida = Mockito.mock(Ciudad.class);
		Mockito.when(ciudadInvalida.getId()).thenReturn(2L);
		assertThrows(CiudadNoValidaParaCita.class, () -> servicio.ejecutar(cita, ciudadInvalida), "");
	}

	@Test
	public void validarExistenCitasSimultaneas() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		Ciudad bogota = new Ciudad(BOGOTA_ID, "Bogota");
		GeneradorCiudadValidaCitaPeluqueria generadorBogota = () -> bogota;

		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().build();
		RepositorioCitaPeluqueria repositorio = Mockito.mock(RepositorioCitaPeluqueria.class);
		Mockito.when(repositorio.crear(cita)).thenReturn(cita);
		Mockito.when(repositorio.existenCitasSimultaneas(cita)).thenReturn(true);

		ServicioCrearCitaPeluqueria servicio = new ServicioCrearCitaPeluqueria(repositorio, generadorBogota);
		assertThrows(CitasSimultaneasException.class, () -> servicio.ejecutar(cita, bogota), "");
	}

	@Test
	public void validarNoExistenCitasSimultaneas() throws PesoNoAceptadoException, FechaInicioCitaInvalidaException {
		Ciudad bogota = new Ciudad(BOGOTA_ID, "Bogota");
		GeneradorCiudadValidaCitaPeluqueria generadorBogota = () -> bogota;

		CitaPeluqueria cita = new CitaPeluqueriaTestDataBuilder().build();
		RepositorioCitaPeluqueria repositorio = Mockito.mock(RepositorioCitaPeluqueria.class);
		Mockito.when(repositorio.crear(cita)).thenReturn(cita);
		Mockito.when(repositorio.existenCitasSimultaneas(cita)).thenReturn(false);

		ServicioCrearCitaPeluqueria servicio = new ServicioCrearCitaPeluqueria(repositorio, generadorBogota);
		assertDoesNotThrow(() -> servicio.ejecutar(cita, bogota), "Se genera la cita");
	}
}
