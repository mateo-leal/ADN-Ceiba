package com.ceiba.citas_medicas.application.factory;

import com.ceiba.citas_medicas.application.command.PersonaCommand;
import com.ceiba.citas_medicas.domain.model.Persona;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

@Component
public class PersonaFactory {

    public Persona build(PersonaCommand command) {
        requireNonNull(command);
        return new Persona(command.getId(), command.getNumeroDocumento(), command.getNombres());
    }
}
