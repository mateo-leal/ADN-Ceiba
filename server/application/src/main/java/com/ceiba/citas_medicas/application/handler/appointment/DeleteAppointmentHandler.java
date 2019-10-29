package com.ceiba.citas_medicas.application.handler.appointment;

import com.ceiba.citas_medicas.domain.service.appointment.DeleteAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteAppointmentHandler {

    private final DeleteAppointmentService deleteAppointmentService;

    @Autowired
    public DeleteAppointmentHandler(DeleteAppointmentService deleteAppointmentService) {
        this.deleteAppointmentService = deleteAppointmentService;
    }

    public void execute(Long id) {
        deleteAppointmentService.execute(id);
    }
}
