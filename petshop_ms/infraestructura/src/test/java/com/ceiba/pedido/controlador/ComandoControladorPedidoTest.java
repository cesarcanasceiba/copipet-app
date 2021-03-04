package com.ceiba.pedido.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.servicio.testdatabuilder.ComandoPedidoTestDataBuilder;
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
@WebMvcTest(ComandoControladorPedido.class)
public class ComandoControladorPedidoTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testCrear() throws JsonProcessingException, Exception {
		ComandoPedido comandoPedido = new ComandoPedidoTestDataBuilder().setId(null).build();
		mocMvc.perform(post("/pedido").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoPedido))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)));
	}

	@Test
	public void testCrearConConversorMoneda() throws JsonProcessingException, Exception {
		ComandoPedido comandoPedido = new ComandoPedidoTestDataBuilder().setId(null).setTipoMoneda("USD").build();
		mocMvc.perform(post("/pedido").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoPedido))).andExpect(status().isOk())
				.andExpect(jsonPath("$.costoTotal", is(219340)));
	}
}
