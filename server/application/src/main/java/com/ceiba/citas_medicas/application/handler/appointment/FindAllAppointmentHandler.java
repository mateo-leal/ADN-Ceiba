package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.factory.AppointmentFactory;
import com.ceiba.citas_medicas.domain.service.appointment.FindAllAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllAppointmentHandler {

    private final FindAllAppointmentService findAllAppointmentService;

    @Autowired
    public FindAllAppointmentHandler(FindAllAppointmentService findAllAppointmentService) {
        this.findAllAppointmentService = findAllAppointmentService;
    }

    public List<AppointmentCommand> execute() {
        return findAllAppointmentService.execute().stream()
                .map(AppointmentFactory::toCommand)
                .collect(Collectors.toList());
    }
}
