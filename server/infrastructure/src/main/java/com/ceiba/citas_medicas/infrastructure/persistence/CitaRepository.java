package com.ceiba.citas_medicas.infrastructure.persistence;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.springframework.data.repository.CrudRepository;

public interface CitaRepository extends CrudRepository<Cita, Long>, CitaPersistence { }
