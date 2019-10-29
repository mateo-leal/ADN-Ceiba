package com.ceiba.citas_medicas.domain.validation;

import com.ceiba.citas_medicas.domain.model.Persona;
import com.ceiba.citas_medicas.domain.persistence.PersonaPersistence;

public class PersonaValidation {

    private final PersonaPersistence persistence;

    public PersonaValidation(PersonaPersistence persistence) {
        this.persistence = persistence;
    }

    public boolean existe(Persona persona) {
        if (persona.getId() == null) {
            return false;
        }
        return persistence.find(persona.getId()).isPresent();
    }
}
