package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.appointment.FindByClientAppointmentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindByClientAppoinmentHandlerTest {

    @Test
    void execute() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var appointment = new Appointment(1L, today, today.plusDays(1), client);
        var service = mock(FindByClientAppointmentService.class);
        doReturn(List.of(appointment)).when(service).execute(any(Client.class));
        var handler = new FindByClientAppoinmentHandler(service);

        // act - assert
        assertThat(handler.execute(new ClientCommand(1L, "123", "John Doe"))).isNotEmpty();
    }
}