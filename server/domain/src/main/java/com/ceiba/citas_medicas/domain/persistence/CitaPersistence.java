package com.ceiba.citas_medicas.domain.persistence;

import com.ceiba.citas_medicas.domain.model.Cita;

import java.util.Collection;
import java.util.Optional;

public interface CitaPersistence {

    Cita save(Cita cita);

    void delete(Cita cita);

    Collection<Cita> findAll();

    Optional<Cita> find(Long id);
}
