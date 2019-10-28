package com.ceiba.citas_medicas.domain.service;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.model.Persona;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CrearCitaServiceTest {

    @Test
    void create_user_when_not_exists() {
        // arrange
        var repository = mock(CitaPersistence.class);
        doReturn(buildCita()).when(repository).save(any(Cita.class));
        var service = new CrearCitaService(repository);

        // act
        var citaCreada = service.execute(buildCita());

        // assert
        assertNotNull(citaCreada);
    }

    @Test
    void create_user_when_exists() {
        // arrange
        var cita = Cita.builder().id(1L).build();
        var repository = mock(CitaPersistence.class);
        doReturn(Optional.of(buildCita())).when(repository).find(anyLong());
        var service = new CrearCitaService(repository);

        // act - assert
        assertThrows(EntityExistsException.class, () -> service.execute(cita));
    }

    private Cita buildCita() {
        return Cita.builder()
                .fechaCita(LocalDateTime.now())
                .fechaSolicitud(LocalDateTime.now())
                .persona(buildPersona())
                .build();
    }

    private Persona buildPersona() {
        return Persona.builder()
                .id(1L)
                .numeroDocumento("123456789")
                .nombres("John Doe")
                .build();
    }
}