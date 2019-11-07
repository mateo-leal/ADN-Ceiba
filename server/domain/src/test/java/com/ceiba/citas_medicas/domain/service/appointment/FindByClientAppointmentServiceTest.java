package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindByClientAppointmentServiceTest {

    @Test
    void find_when_exists() {
        // arrange
        var persistence = mock(AppointmentPersistence.class);
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(today, today.plusDays(1), client);
        doReturn(List.of(appointment)).when(persistence).findByClient(any(Client.class));
        var service = new FindByClientAppointmentService(persistence);

        // act
        var listAppointment = service.execute(client);

        // assert
        assertFalse(listAppointment::isEmpty);
    }

    @Test
    void find_when_not_exists() {
        // arrange
        var persistence = mock(AppointmentPersistence.class);
        var client = new Client("123", "John Doe");
        doReturn(Collections.emptyList()).when(persistence).findByClient(any(Client.class));
        var service = new FindByClientAppointmentService(persistence);

        // act
        var listAppointment = service.execute(client);

        // assert
        assertTrue(listAppointment::isEmpty);
    }
}