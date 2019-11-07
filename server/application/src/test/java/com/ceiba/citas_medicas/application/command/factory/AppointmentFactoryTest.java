package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentFactoryTest {

    @Test
    void toModel() {
        // arrange
        var clientCommand = new ClientCommand(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var command = new AppointmentCommand(1L, today.plusDays(1), today, clientCommand);
        // act
        var appointment = AppointmentFactory.toModel(command);
        // assert
        assertEquals(command.getAppointmentDate(), appointment.getAppointmentDate());
        assertEquals(command.getCreatedAt(), appointment.getCreatedAt());
        assertEquals(clientCommand, ClientFactory.toCommand(appointment.getClient()));
    }

    @Test
    void toModel_createdAt_null() {
        // arrange
        var clientCommand = new ClientCommand(1L, "123", "John Doe");
        var today = LocalDateTime.now();
        var command = new AppointmentCommand(1L, today.plusDays(1), null, clientCommand);
        // act
        var appointment = AppointmentFactory.toModel(command);
        // assert
        assertEquals(command.getAppointmentDate(), appointment.getAppointmentDate());
        assertEquals(LocalDate.now(), appointment.getCreatedAt().toLocalDate());
        assertEquals(clientCommand, ClientFactory.toCommand(appointment.getClient()));
    }

    @Test
    void toCommand() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var today = LocalDateTime.of(2019, Month.OCTOBER, 29, 12, 0);
        var appointment = new Appointment(1L, today, today.plusDays(1), client);
        // act
        var command = AppointmentFactory.toCommand(appointment);
        // assert
        assertEquals(appointment.getId(), command.getId());
        assertEquals(appointment.getAppointmentDate(), command.getAppointmentDate());
        assertEquals(appointment.getCreatedAt(), command.getCreatedAt());
        assertEquals(appointment.getPrice(), command.getPrice());
        assertEquals(appointment.getClient(), ClientFactory.toModel(command.getClient()));
    }
}