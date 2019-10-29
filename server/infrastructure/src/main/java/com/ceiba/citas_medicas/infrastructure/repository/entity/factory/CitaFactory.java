package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.infrastructure.repository.entity.CitaEntity;
import org.springframework.beans.BeanUtils;

public class CitaFactory {

    public static Appointment toModel(CitaEntity entity) {
        var client = PersonaFactory.toModel(entity.getPersona());
        return new Appointment(entity.getId(), entity.getFechaSolicitud(), entity.getFechaCita(), client);
    }

    public static CitaEntity toEntity(Appointment appointment) {
        var entity = new CitaEntity();
        BeanUtils.copyProperties(appointment, entity);
        return entity;
    }
}
