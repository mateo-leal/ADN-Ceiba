package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.FindAllAppointmentHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAllAppointmentControllerTest {

    @Test
    void execute() {
        // arrange
        var handler = mock(FindAllAppointmentHandler.class);
        var command = mock(AppointmentCommand.class);
        doReturn(List.of(command)).when(handler.execute());
        var controller = new FindAllAppointmentController(handler);
        // act
        var response = controller.execute();
        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody()::isEmpty);
    }
}