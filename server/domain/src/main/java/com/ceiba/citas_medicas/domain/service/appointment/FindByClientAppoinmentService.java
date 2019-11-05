package com.ceiba.citas_medicas.domain.service.appointment;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;

import java.util.List;

public class FindByClientAppoinmentService {

    private final AppointmentPersistence appointmentPersistence;

    public FindByClientAppoinmentService(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public List<Appointment> execute(Client client) {
        return appointmentPersistence.findByClient(client);
    }
}
