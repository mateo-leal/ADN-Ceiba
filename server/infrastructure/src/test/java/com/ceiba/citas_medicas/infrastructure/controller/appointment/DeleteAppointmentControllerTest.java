package com.ceiba.citas_medicas.infrastructure.controller.appointment;

import com.ceiba.citas_medicas.application.handler.appointment.DeleteAppointmentHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class DeleteAppointmentControllerTest {

    @Test
    void execute() {
        // arrange
        var handler = mock(DeleteAppointmentHandler.class);
        var controller = new DeleteAppointmentController(handler);
        // act
        var response = controller.execute(1L);
        // assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}