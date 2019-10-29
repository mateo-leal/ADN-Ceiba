package com.ceiba.citas_medicas.application.service;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;

public class CrearCitaService {

    private final CitaPersistence repository;

    public CrearCitaService(CitaPersistence repository) {
        this.repository = repository;
    }

    public Cita execute(Cita cita) {
        exists(cita);
        return this.repository.save(cita);
    }

    private void exists(Cita cita) {

    }
}
