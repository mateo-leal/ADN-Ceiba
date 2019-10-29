package com.ceiba.citas_medicas.application.service.adapter;

import com.ceiba.citas_medicas.application.exception.EntityNotExistsException;
import com.ceiba.citas_medicas.application.service.api.CitaService;
import com.ceiba.citas_medicas.application.use_case.CrearCitaUseCase;
import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CitaServiceAdapter implements CitaService {

    private final CitaPersistence persistence;
    private final CrearCitaUseCase crearCita;

    @Autowired
    public CitaServiceAdapter(CitaPersistence persistence, CrearCitaUseCase crearCita) {
        this.persistence = persistence;
        this.crearCita = crearCita;
    }

    @Override
    public Cita save(Cita cita) {
        return crearCita.execute(cita);
    }

    @Override
    public void delete(Long id) {
        find(id).ifPresentOrElse(persistence::delete, () -> {
            throw new EntityNotExistsException();
        });
    }

    @Override
    public List<Cita> findAll() {
        return persistence.findAll();
    }

    @Override
    public Optional<Cita> find(Long id) {
        return persistence.find(id);
    }
}
