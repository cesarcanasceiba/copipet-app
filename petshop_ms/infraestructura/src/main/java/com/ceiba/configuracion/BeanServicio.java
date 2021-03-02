package com.ceiba.configuracion;

import com.ceiba.citapeluqueria.puerto.generadorciudad.GeneradorCiudadValidaCitaPeluqueria;
import com.ceiba.citapeluqueria.puerto.repositorio.RepositorioCitaPeluqueria;
import com.ceiba.citapeluqueria.servicio.ServicioCrearCitaPeluqueria;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCitaPeluqueria servicioCrearCitaPeluqueria(RepositorioCitaPeluqueria repositorioCitaPeluqueria,
            GeneradorCiudadValidaCitaPeluqueria ciudadValida) {
        return new ServicioCrearCitaPeluqueria(repositorioCitaPeluqueria, ciudadValida);
    }

    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido) {
        return new ServicioCrearPedido(repositorioPedido);
    }
}
