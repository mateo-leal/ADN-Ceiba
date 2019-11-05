package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.AppointmentRepository;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.AppointmentEntity;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.AppointmentFactory;
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
        var repository = mock(AppointmentRepository.class);
        var clientRepository = mock(ClientRepository.class);
        doReturn(AppointmentFactory.toEntity(appointment)).when(repository).save(any(AppointmentEntity.class));
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
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
        var repository = mock(AppointmentRepository.class);
        var clientRepository = mock(ClientRepository.class);
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
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
        var repository = mock(AppointmentRepository.class);
        var clientRepository = mock(ClientRepository.class);
        doReturn(List.of(AppointmentFactory.toEntity(appointment))).when(repository).findAll();
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
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
        var repository = mock(AppointmentRepository.class);
        var clientRepository = mock(ClientRepository.class);
        doReturn(Optional.of(AppointmentFactory.toEntity(appointment))).when(repository).findById(anyLong());
        var appointmentSpringJpaAdapter = new AppointmentSpringJpaAdapter(repository, clientRepository);
        // act
        var optionalAppointment = appointmentSpringJpaAdapter.find(1L);
        // assert
        assertTrue(optionalAppointment::isPresent);
    }
}