package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(appointment.getAppointmentDate()).isEqualTo(command.getAppointmentDate());
        assertThat(appointment.getCreatedAt()).isEqualTo(command.getCreatedAt());
        assertThat(ClientFactory.toCommand(appointment.getClient())).isEqualTo(clientCommand);
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
        assertThat(appointment.getAppointmentDate()).isEqualTo(command.getAppointmentDate());
        assertThat(appointment.getCreatedAt().toLocalDate()).isEqualTo(LocalDate.now());
        assertThat(ClientFactory.toCommand(appointment.getClient())).isEqualTo(clientCommand);
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
        assertThat(command.getId()).isEqualTo(appointment.getId());
        assertThat(command.getAppointmentDate()).isEqualTo(appointment.getAppointmentDate());
        assertThat(command.getCreatedAt()).isEqualTo(appointment.getCreatedAt());
        assertThat(command.getPrice()).isEqualTo(appointment.getPrice());
        assertThat(ClientFactory.toModel(command.getClient())).isEqualTo(appointment.getClient());
    }
}