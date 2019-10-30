package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.service.appointment.CreateAppointmentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class CreateAppointmentHandlerTest {

    @Test
    void execute() {
        // arrange
        var clientCommand = new ClientCommand(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var command = new AppointmentCommand(1L, today.plusDays(1), today, clientCommand);
        var service = mock(CreateAppointmentService.class);
        var handler = new CreateAppointmentHandler(service);

        // act - assert
        assertDoesNotThrow(() -> handler.execute(command));
    }
}