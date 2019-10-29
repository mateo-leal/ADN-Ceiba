package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.client.CreateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateClientHandler {

    private final CreateClientService createClientService;

    @Autowired
    public CreateClientHandler(CreateClientService createClientService) {
        this.createClientService = createClientService;
    }

    public void execute(Client client) {
        createClientService.execute(client);
    }
}
