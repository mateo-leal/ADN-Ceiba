package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Persona;
import com.ceiba.citas_medicas.infrastructure.repository.entity.PersonaEntity;
import org.springframework.beans.BeanUtils;

public class PersonaFactory {

    public static Persona toModel(PersonaEntity entity) {
        var persona = new Persona();
        BeanUtils.copyProperties(entity, persona);
        return persona;
    }

    public static PersonaEntity toEntity(Persona persona) {
        var entity = new PersonaEntity();
        BeanUtils.copyProperties(persona, entity);
        return entity;
    }
}
