package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.CreateAppointmentHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CreateAppointmentControllerTest {

    @Test
    void execute() {
        // arrange
        var handler = mock(CreateAppointmentHandler.class);
        var command = mock(AppointmentCommand.class);
        var controller = new CreateAppointmentController(handler);
        // act
        var response = controller.execute(command);
        // assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}