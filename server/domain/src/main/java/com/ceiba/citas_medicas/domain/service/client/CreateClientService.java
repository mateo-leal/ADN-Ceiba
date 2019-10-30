package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.exception.EntityExistsException;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;

public class CreateClientService {

    private final ClientPersistence clientPersistence;

    public CreateClientService(ClientPersistence clientPersistence) {
        this.clientPersistence = clientPersistence;
    }

    public void execute(Client client) {
        clientExists(client);
        clientPersistence.save(client);
    }

    private void clientExists(Client client) {
        if (client.getId() != null) {
            clientPersistence.find(client.getId())
                    .ifPresent(client1 -> {
                        throw new EntityExistsException();
                    });
        }
    }
}
