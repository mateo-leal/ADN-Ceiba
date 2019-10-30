package com.ceiba.citas_medicas.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void instance_when_same_day() {
        // arrange
        var persona = new Client("123", "John Doe");

        // act - assert
        assertThrows(IllegalArgumentException.class, () -> new Appointment(LocalDateTime.now(), persona));
    }

    @Test
    void instance_when_weekend() {
        // arrange
        var persona = new Client("123", "John Doe");
        // weekend
        var fechaCreacion = LocalDateTime.of(2019, Month.OCTOBER, 26, 12, 0);

        // act - assert
        assertThrows(IllegalArgumentException.class, () -> new Appointment(fechaCreacion, LocalDateTime.now(), persona));
    }

    @Test
    void instance_when_fechaCreacion_greater() {
        // arrange
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var persona = new Client("123", "John Doe");

        // act - assert
        assertThrows(IllegalArgumentException.class, () -> new Appointment(today.plusDays(1), today, persona));
    }

    @Test
    void instance_when_correct() {
        // arrange
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var persona = new Client("123", "John Doe");

        // act
        var cita = new Appointment(today, today.plusDays(1), persona);

        // assert
        assertNotNull(cita);
    }

    @Test
    void getter_setter() {
        // arrange
        var id = 1L;
        var fechaCreacion = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var fechaCita = fechaCreacion.plusDays(1);
        var persona = new Client("123", "John Doe");
        var cita = new Appointment(id, fechaCreacion, fechaCita, persona);

        // act
        cita.setAppointmentDate(fechaCita);
        cita.setClient(persona);

        // assert
        assertEquals(id, cita.getId());
        assertEquals(fechaCreacion, cita.getCreatedAt());
        assertEquals(fechaCita, cita.getAppointmentDate());
        assertEquals(persona, cita.getClient());
    }
}