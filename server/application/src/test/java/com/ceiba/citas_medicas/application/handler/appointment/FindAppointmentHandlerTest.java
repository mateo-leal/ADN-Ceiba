package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.appointment.FindAppointmentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAppointmentHandlerTest {

    @Test
    void execute() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var appointment = new Appointment(1L, today, today.plusDays(1), client);
        var service = mock(FindAppointmentService.class);
        doReturn(Optional.of(appointment)).when(service).execute(anyLong());
        var handler = new FindAppointmentHandler(service);

        // act - assert
        assertTrue(() -> handler.execute(1L).isPresent());
    }
}