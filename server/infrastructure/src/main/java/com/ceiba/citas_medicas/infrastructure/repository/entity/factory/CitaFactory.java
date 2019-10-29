package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.infrastructure.repository.entity.CitaEntity;
import org.springframework.beans.BeanUtils;

public class CitaFactory {

    public static Cita toModel(CitaEntity entity) {
        var cita = new Cita();
        BeanUtils.copyProperties(entity, cita);
        return cita;
    }

    public static CitaEntity toEntity(Cita cita) {
        var entity = new CitaEntity();
        BeanUtils.copyProperties(cita, entity);
        return entity;
    }
}
