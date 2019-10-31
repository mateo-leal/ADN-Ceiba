package com.ceiba.citas_medicas.infrastructure.repository.entity.factory;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;

public final class ClientFactory {

    private ClientFactory() { }

    public static Client toModel(ClientEntity entity) {
        return new Client(entity.getId(), entity.getDocumentNumber(), entity.getFullName());
    }

    public static ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .fullName(client.getFullName())
                .documentNumber(client.getDocumentNumber())
                .build();
    }
}
