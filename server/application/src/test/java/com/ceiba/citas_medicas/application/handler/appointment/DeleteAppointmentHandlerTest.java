package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.domain.service.appointment.DeleteAppointmentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class DeleteAppointmentHandlerTest {

    @Test
    void execute() {
        // arrange
        var service = mock(DeleteAppointmentService.class);
        var handler = new DeleteAppointmentHandler(service);

        // act - assert
        assertDoesNotThrow(() -> handler.execute(1L));
    }
}