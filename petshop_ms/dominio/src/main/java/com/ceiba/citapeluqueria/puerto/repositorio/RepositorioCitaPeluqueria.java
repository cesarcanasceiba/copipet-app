package com.ceiba.citapeluqueria.puerto.repositorio;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.repositorio.RepositorioComandoInterface;

public interface RepositorioCitaPeluqueria extends RepositorioComandoInterface<CitaPeluqueria> {

	boolean existenCitasSimultaneas(CitaPeluqueria citaPeluqueria);

}
