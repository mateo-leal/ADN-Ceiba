package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.exception.EntityNotExistsException;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;

public class DeleteAppointmentService {

    private final AppointmentPersistence appointmentPersistence;

    public DeleteAppointmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public void execute(Long id) {
        appointmentPersistence.find(id)
                .ifPresentOrElse(appointmentPersistence::delete, () -> {
                    throw new EntityNotExistsException();
                });
    }
}
