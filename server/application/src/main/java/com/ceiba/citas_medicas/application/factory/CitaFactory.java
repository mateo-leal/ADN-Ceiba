package com.ceiba.citas_medicas.application.factory;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.domain.model.Cita;

import static java.util.Objects.requireNonNull;

public class CitaFactory {

    private final PersonaFactory personaFactory;

    public CitaFactory(PersonaFactory personaFactory) {
        this.personaFactory = personaFactory;
    }

    public Cita build(CitaCommand command) {
        requireNonNull(command);
        var persona = personaFactory.build(command.getPersona());
        return new Cita(command.getId(), command.getFechaSolicitud(), command.getFechaCita(), persona);
    }
}
