package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.factory.AppointmentFactory;
import com.ceiba.citas_medicas.domain.service.appointment.FindAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindAppointmentHandler {

    private final FindAppointmentService findAppointmentService;

    @Autowired
    public FindAppointmentHandler(FindAppointmentService findAppointmentService) {
        this.findAppointmentService = findAppointmentService;
    }

    public Optional<AppointmentCommand> execute(Long id) {
        return findAppointmentService.execute(id)
                .map(AppointmentFactory::toCommand);
    }
}
