package com.ceiba.producto.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorProducto.class)
public class ConsultaControladorProductoTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testListar() throws Exception {
		MockHttpServletRequestBuilder request = get("/producto").contentType(MediaType.APPLICATION_JSON);
		mocMvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void testListarPorCategoria() throws Exception {
		MockHttpServletRequestBuilder request = get("/producto").contentType(MediaType.APPLICATION_JSON)
				.param("categoria", "4");
		mocMvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(22)));
	}

	@Test
	public void testConsultarProductoDetalle() throws Exception {
		mocMvc.perform(get("/producto/{id}", 2L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.nombre", is("Ringo Vitality Super Premium Cachorros")));
	}
}
