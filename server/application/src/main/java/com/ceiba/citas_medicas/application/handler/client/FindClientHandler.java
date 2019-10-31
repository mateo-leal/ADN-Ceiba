package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.application.command.factory.ClientFactory;
import com.ceiba.citas_medicas.domain.service.client.FindClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindClientHandler {

    private final FindClientService findClientService;

    @Autowired
    public FindClientHandler(FindClientService findClientService) {
        this.findClientService = findClientService;
    }

    public Optional<ClientCommand> execute(String documentNumber) {
        return findClientService.execute(documentNumber)
                .map(ClientFactory::toCommand);
    }
}
