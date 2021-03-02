package com.ceiba.repositorio;

public interface RepositorioComandoInterface<T> {
    /**
     * Crea un elemento del sistema
     * 
     * @param entity
     * @return el elemento generado
     */
    T crear(T entity);
}
