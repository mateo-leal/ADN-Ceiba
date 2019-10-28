package com.ceiba.citas_medicas.infrastructure.persistence;

import com.ceiba.citas_medicas.domain.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> { }
