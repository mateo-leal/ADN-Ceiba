package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.entity.PersonaEntity;

public final class PersonaFactory {

    private PersonaFactory () { }

    public static Client toModel(PersonaEntity entity) {
        return new Client(entity.getId(), entity.getNumeroDocumento(), entity.getNombres());
    }

    public static PersonaEntity toEntity(Client client) {
        return PersonaEntity.builder()
                .id(client.getId())
                .nombres(client.getFullName())
                .numeroDocumento(client.getDocumentNumber())
                .build();
    }
}
