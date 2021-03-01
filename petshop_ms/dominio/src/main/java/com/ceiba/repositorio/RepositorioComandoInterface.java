package com.ceiba.repositorio;

public interface RepositorioComandoInterface<T> {
    /**
     * Crea un elemento del sistema
     * 
     * @param entity
     * @return el elemento generado
     */
    T crear(T entity);

    /**
     * Permite actualizar una entidad
     * 
     * @param entity
     */
    void actualizar(T entity);
}
