package com.ceiba.citas_medicas.application.use_case;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrearCitaUseCase {

    private final CitaPersistence persistence;
    private final CrearPersonaUseCase crearPersona;

    @Autowired
    public CrearCitaUseCase(CitaPersistence persistence, CrearPersonaUseCase crearPersona) {
        this.persistence = persistence;
        this.crearPersona = crearPersona;
    }

    public Cita execute(Cita cita) {
        cita.setPersona(crearPersona.execute(cita.getPersona()));
        return persistence.save(cita);
    }
}
