package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.appointment.FindAllAppointmentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAllAppointmentHandlerTest {

    @Test
    void execute() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var appointment = new Appointment(1L, today, today.plusDays(1), client);
        var service = mock(FindAllAppointmentService.class);
        doReturn(List.of(appointment)).when(service).execute();
        var handler = new FindAllAppointmentHandler(service);

        // act - assert
        assertThat(handler.execute()).isNotEmpty();
    }
}