package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAppointmentServiceTest {

    @Test
    void find_when_exists() {
        // arrange
        var persistence = mock(AppointmentPersistence.class);
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(today, today.plusDays(1), client);
        doReturn(Optional.of(appointment)).when(persistence).find(anyLong());
        var service = new FindAppointmentService(persistence);

        // act
        var optionalAppointment = service.execute(1L);

        // assert
        assertTrue(optionalAppointment::isPresent);
    }

    @Test
    void find_when_not_exists() {
        // arrange
        var persistence = mock(AppointmentPersistence.class);
        doReturn(Optional.empty()).when(persistence).find(anyLong());
        var service = new FindAppointmentService(persistence);

        // act
        var optionalAppointment = service.execute(1L);

        // assert
        assertFalse(optionalAppointment::isPresent);
    }
}