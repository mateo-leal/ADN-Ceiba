package com.ceiba.citas_medicas.domain.service;

import java.util.Collection;
import java.util.Optional;

/**
 * Servicio genérico que incluye todos los métodos de un CRUD.
 * @param <E> clase de la entidad
 */
public interface Service<E, PK> {

    /**
     * Obtiene una entidad por su id
     * @return id
     */
    Optional<E> find(PK id);

    /**
     * Obtiene todas los registros de la tabla
     * @return registros
     */
    Collection<E> findAll();

    /**
     * Crea un registro de la entidad
     * @param e entidad
     */
    void create(E e);

    /**
     * Actualiza un registro
     * @param e entidad
     * @return entidad actualizada
     */
    E update(E e);

    /**
     * Elimina una entidad
     */
    void delete();
}
