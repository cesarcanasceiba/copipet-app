package com.ceiba.citapeluqueria.puerto.repositorio;

import com.ceiba.citapeluqueria.modelo.entidad.CitaPeluqueria;
import com.ceiba.repositorio.CommandRepositoryInterface;

public interface RepositorioCitaPeluqueria extends CommandRepositoryInterface<CitaPeluqueria>{
	
	boolean existenCitasSimultaneas();
}
