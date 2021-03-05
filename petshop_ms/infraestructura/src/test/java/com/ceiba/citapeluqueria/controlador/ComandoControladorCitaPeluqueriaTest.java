package com.ceiba.citapeluqueria.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.citapeluqueria.comando.ComandoCitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.testdatabuilder.ComandoCitaPeluqueriaTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCitaPeluqueria.class)
public class ComandoControladorCitaPeluqueriaTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrear() throws JsonProcessingException, Exception {
		ComandoCitaPeluqueria comandoCita = new ComandoCitaPeluqueriaTestDataBuilder().setId(null).build();
		mocMvc.perform(post("/citapeluqueria").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoCita))).andExpect(status().isOk());
	}
}
