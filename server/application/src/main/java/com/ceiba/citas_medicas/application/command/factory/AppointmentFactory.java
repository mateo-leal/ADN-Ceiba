package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.domain.model.Appointment;

public final class AppointmentFactory {

    private AppointmentFactory() { }

    public static Appointment toModel(AppointmentCommand command) {
        var client = ClientFactory.toModel(command.getClient());
        return new Appointment(command.getId(), command.getCreatedAt(), command.getAppointmentDate(), client);
    }

    public static AppointmentCommand toCommand(Appointment appointment) {
        var clientCommand = ClientFactory.toCommand(appointment.getClient());
        return new AppointmentCommand(appointment.getId(), appointment.getAppointmentDate(),
                appointment.getCreatedAt(), clientCommand);
    }
}
