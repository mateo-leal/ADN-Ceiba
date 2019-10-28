package com.ceiba.citas_medicas.application.factory;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.domain.model.Persona;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CitaFactoryTest {

    @Test
    void build() {
        // arrange
        final var id = 1L;
        final var fechaSolicitud = LocalDateTime.now();
        final var fechaCreacion = LocalDateTime.now();
        final var persona = new Persona();
        var personaFactory = mock(PersonaFactory.class);
        doReturn(persona).when(personaFactory).build(any());
        var citaCommand = new CitaCommand(id, fechaSolicitud, fechaCreacion, null);
        var factory = new CitaFactory(personaFactory);

        // act
        var cita = factory.build(citaCommand);

        // assert
        assertNotNull(cita);
        cita.getId().ifPresent(idCita -> assertEquals(id, idCita));
        assertEquals(fechaSolicitud, cita.getFechaSolicitud());
        assertEquals(fechaCreacion, cita.getFechaCita());
        assertEquals(persona, cita.getPersona());
    }
}