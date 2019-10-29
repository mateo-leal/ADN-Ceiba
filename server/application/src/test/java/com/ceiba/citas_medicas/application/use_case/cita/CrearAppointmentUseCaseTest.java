package com.ceiba.citas_medicas.application.use_case.cita;

import com.ceiba.citas_medicas.application.use_case.persona.CrearPersonaUseCase;
import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CrearAppointmentUseCaseTest {

    @Test
    void execute() {
        // arrange
        final var fechaSolicitud = LocalDateTime.now();
        final var fechaCreacion = LocalDateTime.now();
        final var persona = new Client();
        var cita = new Appointment(fechaSolicitud, fechaCreacion, null);
        var persistence = mock(AppointmentPersistence.class);
        var crearPersona = mock(CrearPersonaUseCase.class);
        doReturn(persona).when(crearPersona).execute(any());
        doReturn(cita).when(persistence).save(any());
        var useCase = new CrearCitaUseCase(persistence, crearPersona);

        // act
        var citaNew = useCase.execute(cita);

        // assert
        assertEquals(fechaSolicitud, citaNew.getCreatedAt());
        assertEquals(fechaCreacion, citaNew.getAppointmentDate());
        assertEquals(persona, citaNew.getClient());
    }
}