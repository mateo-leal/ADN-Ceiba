package com.ceiba.citas_medicas.application.service.api;

import com.ceiba.citas_medicas.domain.model.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {

    Cita save(Cita cita);

    void delete(Long id);

    List<Cita> findAll();

    Optional<Cita> find(Long id);
}
