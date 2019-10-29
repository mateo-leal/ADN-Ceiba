package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;

import java.util.List;

public class FindAllAppointmentService {

    private final AppointmentPersistence appointmentPersistence;

    public FindAllAppointmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public List<Appointment> execute() {
        return appointmentPersistence.findAll();
    }
}
