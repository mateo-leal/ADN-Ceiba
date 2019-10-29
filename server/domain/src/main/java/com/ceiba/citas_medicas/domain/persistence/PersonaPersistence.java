package com.ceiba.citas_medicas.domain.persistence;

import com.ceiba.citas_medicas.domain.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaPersistence {

    Persona save(Persona Persona);

    void delete(Persona Persona);

    List<Persona> findAll();

    Optional<Persona> find(Long id);
}
