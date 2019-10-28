package com.ceiba.citas_medicas.domain.service;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;

import javax.persistence.EntityExistsException;

public class CrearCitaService {

    private CitaPersistence repository;

    public CrearCitaService(CitaPersistence repository) {
        this.repository = repository;
    }

    public Cita execute(Cita cita) {
        exists(cita);
        return this.repository.save(cita);
    }

    private void exists(Cita cita) {
        cita.getId()
                .flatMap(repository::find)
                .ifPresent(cita1 -> {
                    throw new EntityExistsException();
                });
    }
}
