package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.factory.AppointmentFactory;
import com.ceiba.citas_medicas.domain.service.appointment.CreateAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAppointmentHandler {

    private final CreateAppointmentService createAppointmentService;

    @Autowired
    public CreateAppointmentHandler(CreateAppointmentService createAppointmentService) {
        this.createAppointmentService = createAppointmentService;
    }

    public void execute(AppointmentCommand command) {
        var appointment = AppointmentFactory.toModel(command);
        createAppointmentService.execute(appointment);
    }
}
