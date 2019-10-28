package com.ceiba.citas_medicas.application.factory;

import com.ceiba.citas_medicas.application.command.PersonaCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonaFactoryTest {

    @Test
    void build() {
        // arrange
        final var id = 1L;
        final var numeroDocumento = "123";
        final var nombres = "John Doe";
        var command = new PersonaCommand(id, numeroDocumento, nombres);
        var factory = new PersonaFactory();
        // act
        var persona = factory.build(command);

        // assert
        assertNotNull(persona);
        assertEquals(id, persona.getId());
        assertEquals(numeroDocumento, persona.getNumeroDocumento());
        assertEquals(nombres, persona.getNombres());
    }
}