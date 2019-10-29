package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.entity.PersonaEntity;
import org.springframework.beans.BeanUtils;

public class PersonaFactory {

    public static Client toModel(PersonaEntity entity) {
        return new Client(entity.getId(), entity.getNumeroDocumento(), entity.getNombres());
    }

    public static PersonaEntity toEntity(Client client) {
        var entity = new PersonaEntity();
        BeanUtils.copyProperties(client, entity);
        return entity;
    }
}
