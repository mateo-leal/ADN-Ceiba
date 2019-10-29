package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.exception.EntityNotExistsException;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;

public class DeleteClientService {

    private final ClientPersistence clientPersistence;

    public DeleteClientService(ClientPersistence clientPersistence) {
        this.clientPersistence = clientPersistence;
    }

    public void execute(Long id) {
        clientPersistence.find(id)
                .ifPresentOrElse(clientPersistence::delete, () -> {
                    throw new EntityNotExistsException();
                });
    }
}
