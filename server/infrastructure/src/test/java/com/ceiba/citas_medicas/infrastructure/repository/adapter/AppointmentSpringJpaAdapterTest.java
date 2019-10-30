package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.CitaRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.CitaEntity;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.CitaFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class AppointmentSpringJpaAdapterTest {

    @Test
    void save() {
        // arrange
        var id = 1L;
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(id, today, today.plusDays(1), client);
        var repository = mock(CitaRepository.class);
        doReturn(CitaFactory.toEntity(appointment)).when(repository).save(any(CitaEntity.class));
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository);
        // act
        var savedAppointment = appointmentSpringJpaAdapter.save(appointment);
        // assert
        assertEquals(appointment, savedAppointment);
    }

    @Test
    void delete() {
        // arrange
        var id = 1L;
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(id, today, today.plusDays(1), client);
        var repository = mock(CitaRepository.class);
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository);
        // act - assert
        appointmentSpringJpaAdapter.delete(appointment);
    }

    @Test
    void findAll() {
        // arrange
        var id = 1L;
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(id, today, today.plusDays(1), client);
        var repository = mock(CitaRepository.class);
        doReturn(List.of(CitaFactory.toEntity(appointment))).when(repository).findAll();
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository);
        // act
        var appointmentList = appointmentSpringJpaAdapter.findAll();
        // assert
        assertFalse(appointmentList::isEmpty);
    }

    @Test
    void find() {
        // arrange
        var id = 1L;
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var client = new Client("123", "John Doe");
        var appointment = new Appointment(id, today, today.plusDays(1), client);
        var repository = mock(CitaRepository.class);
        doReturn(Optional.of(CitaFactory.toEntity(appointment))).when(repository).findById(anyLong());
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository);
        // act
        var optionalAppointment = appointmentSpringJpaAdapter.find(1L);
        // assert
        assertTrue(optionalAppointment::isPresent);
    }
}