package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;

import java.util.Optional;

public class FindClientService {

    private final ClientPersistence clientPersistence;

    public FindClientService(ClientPersistence clientPersistence) {
        this.clientPersistence = clientPersistence;
    }

    public Optional<Client> execute(String documentNumber) {
        return clientPersistence.findByDocumentNumber(documentNumber);
    }
}
