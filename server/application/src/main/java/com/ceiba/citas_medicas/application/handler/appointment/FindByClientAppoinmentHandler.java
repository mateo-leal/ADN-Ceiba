package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.application.command.AppointmentCommand;
import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.command.factory.AppointmentFactory;
import com.ceiba.citas_medicas.application.command.factory.ClientFactory;
import com.ceiba.citas_medicas.domain.service.appointment.FindByClientAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindByClientAppoinmentHandler {

    private final FindByClientAppointmentService findByClientAppointmentService;

    @Autowired
    public FindByClientAppoinmentHandler(FindByClientAppointmentService findByClientAppointmentService) {
        this.findByClientAppointmentService = findByClientAppointmentService;
    }

    public List<AppointmentCommand> execute(ClientCommand clientCommand) {
        return findByClientAppointmentService.execute(ClientFactory.toModel(clientCommand)).stream()
                .map(AppointmentFactory::toCommand)
                .collect(Collectors.toList());
    }
}
