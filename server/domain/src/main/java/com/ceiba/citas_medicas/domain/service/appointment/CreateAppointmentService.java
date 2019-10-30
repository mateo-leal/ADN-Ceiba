package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.exception.EntityExistsException;
import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;

public class CreateAppointmentService {

    private final AppointmentPersistence appointmentPersistence;

    public CreateAppointmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public void execute(Appointment appointment) {
        appointmentExists(appointment);
        appointmentPersistence.save(appointment);
    }

    private void appointmentExists(Appointment appointment) {
        if (appointment.getId() != null) {
            appointmentPersistence.find(appointment.getId())
                    .ifPresent(appointment1 -> {
                        throw new EntityExistsException();
                    });
        }
    }
}
