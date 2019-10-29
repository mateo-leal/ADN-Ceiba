package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Client;

public class ClientFactory {

    public static Client toModel(ClientCommand command) {
        return new Client(command.getId(), command.getDocumentNumber(), command.getFullName());
    }

    public static ClientCommand toCommand(Client client) {
        return new ClientCommand(client.getId(), client.getDocumentNumber(), client.getFullName());
    }
}
