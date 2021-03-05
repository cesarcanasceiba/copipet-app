package com.ceiba.citapeluqueria.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
@WebMvcTest(ControladorConsultaPeluquero.class)
public class ControladorConsultaPeluqueroTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void testListar() throws Exception {
		MockHttpServletRequestBuilder request = get("/peluquero").contentType(MediaType.APPLICATION_JSON);
		mocMvc.perform(request).andExpect(status().isOk());
	}
}
