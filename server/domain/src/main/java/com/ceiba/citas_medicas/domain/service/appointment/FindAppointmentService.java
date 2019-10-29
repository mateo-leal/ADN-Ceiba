package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;

import java.util.Optional;

public class FindAppointmentService {

    private final AppointmentPersistence appointmentPersistence;

    public FindAppointmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public Optional<Appointment> execute(Long id) {
        return appointmentPersistence.find(id);
    }
}
