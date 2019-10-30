package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.application.command.ClientCommand;
import com.ceiba.citas_medicas.domain.service.client.CreateClientService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class CreateClientHandlerTest {

    @Test
    void execute() {
        // arrange
        var command = new ClientCommand(1L, "123", "John Doe");
        var service = mock(CreateClientService.class);
        var handler = new CreateClientHandler(service);

        // act - assert
        assertDoesNotThrow(() -> handler.execute(command));
    }
}