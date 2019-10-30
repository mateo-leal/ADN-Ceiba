package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.infrastructure.repository.entity.CitaEntity;

public final class CitaFactory {

    private CitaFactory() { }

    public static Appointment toModel(CitaEntity entity) {
        var client = PersonaFactory.toModel(entity.getPersona());
        return new Appointment(entity.getId(), entity.getFechaSolicitud(), entity.getFechaCita(), client);
    }

    public static CitaEntity toEntity(Appointment appointment) {
        return CitaEntity.builder()
                .id(appointment.getId())
                .fechaCita(appointment.getAppointmentDate())
                .fechaSolicitud(appointment.getCreatedAt())
                .persona(PersonaFactory.toEntity(appointment.getClient()))
                .build();
    }
}
