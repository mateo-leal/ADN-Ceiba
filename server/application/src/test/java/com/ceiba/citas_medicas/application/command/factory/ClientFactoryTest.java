package com.ceiba.citas_medicas.application.command.factory;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.model.Client;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientFactoryTest {

    @Test
    void toModel() {
        // arrange
        var command = new ClientCommand(1L, "123", "John Doe");
        // act
        var client = ClientFactory.toModel(command);
        // assert
        assertThat(client.getId()).isEqualTo(command.getId());
        assertThat(client.getDocumentNumber()).isEqualTo(command.getDocumentNumber());
        assertThat(client.getFullName()).isEqualTo(command.getFullName());
    }

    @Test
    void toCommand() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        // act
        var command = ClientFactory.toCommand(client);
        // assert
        assertThat(command.getId()).isEqualTo(client.getId());
        assertThat(command.getDocumentNumber()).isEqualTo(client.getDocumentNumber());
        assertThat(command.getFullName()).isEqualTo(client.getFullName());
    }
}