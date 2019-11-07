package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.infrastructure.repository.entity.AppointmentEntity;

public final class AppointmentFactory {

    private AppointmentFactory() { }

    public static Appointment toModel(AppointmentEntity entity) {
        var client = ClientFactory.toModel(entity.getClient());
        return new Appointment(entity.getId(), entity.getCreatedAt(), entity.getAppointmentDate(), client);
    }

    public static AppointmentEntity toEntity(Appointment appointment) {
        return AppointmentEntity.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .createdAt(appointment.getCreatedAt())
                .price(appointment.getPrice())
                .client(ClientFactory.toEntity(appointment.getClient()))
                .build();
    }
}
