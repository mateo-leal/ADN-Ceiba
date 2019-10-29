package com.ceiba.citas_medicas.application.use_case;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.application.factory.CitaFactory;
import com.ceiba.citas_medicas.application.use_case.adapter.CrearCitaUseCaseAdapter;
import com.ceiba.citas_medicas.application.service.CrearCitaService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

class CrearCitaUseCaseTest {

    @Test
    void execute() {
        // arrange
        final var id = 1L;
        final var fechaSolicitud = LocalDateTime.now();
        final var fechaCreacion = LocalDateTime.now();
        var command = new CitaCommand(id, fechaSolicitud, fechaCreacion, null);
        var service = mock(CrearCitaService.class);
        var factory = mock(CitaFactory.class);
        var useCase = new CrearCitaUseCaseAdapter(service, factory);

        // act

        // assert


    }
}