package com.ceiba.citas_medicas.application.use_case;

import com.ceiba.citas_medicas.domain.model.Persona;
import com.ceiba.citas_medicas.domain.persistence.PersonaPersistence;
import com.ceiba.citas_medicas.domain.validation.PersonaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrearPersonaUseCase {

    private final PersonaPersistence persistence;
    private final PersonaValidation validation;

    @Autowired
    public CrearPersonaUseCase(PersonaPersistence persistence, PersonaValidation validation) {
        this.persistence = persistence;
        this.validation = validation;
    }

    public Persona execute(Persona persona) {
        if (!validation.existe(persona)) {
            persona = persistence.save(persona);
        }
        return persona;
    }
}
