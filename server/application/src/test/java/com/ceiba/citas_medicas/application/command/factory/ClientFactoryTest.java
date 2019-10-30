package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientFactoryTest {

    @Test
    void toModel() {
        // arrange
        var command = new ClientCommand(1L, "123", "John Doe");
        // act
        var client = ClientFactory.toModel(command);
        // assert
        assertEquals(command.getId(), client.getId());
        assertEquals(command.getDocumentNumber(), client.getDocumentNumber());
        assertEquals(command.getFullName(), client.getFullName());
    }

    @Test
    void toCommand() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        // act
        var command = ClientFactory.toCommand(client);
        // assert
        assertEquals(client.getId(), command.getId());
        assertEquals(client.getDocumentNumber(), command.getDocumentNumber());
        assertEquals(client.getFullName(), command.getFullName());
    }
}