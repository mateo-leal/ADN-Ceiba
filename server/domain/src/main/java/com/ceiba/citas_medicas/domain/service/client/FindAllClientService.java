package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;

import java.util.List;

public class FindAllClientService {

    private final ClientPersistence clientPersistence;

    public FindAllClientService(ClientPersistence clientPersistence) {
        this.clientPersistence = clientPersistence;
    }

    public List<Client> execute() {
        return clientPersistence.findAll();
    }
}
