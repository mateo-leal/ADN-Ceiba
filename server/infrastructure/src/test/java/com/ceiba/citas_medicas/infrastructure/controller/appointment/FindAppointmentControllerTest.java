package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.handler.appointment.FindAppointmentHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAppointmentControllerTest {

    @Test
    void execute() {
        // arrange
        var handler = mock(FindAppointmentHandler.class);
        var command = mock(AppointmentCommand.class);
        doReturn(List.of(command)).when(handler).execute(anyLong());
        var controller = new FindAppointmentController(handler);
        // act
        var response = controller.execute(1L);
        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}