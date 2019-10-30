package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.service.client.DeleteClientService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class DeleteClientHandlerTest {

    @Test
    void execute() {
        // arrange
        var service = mock(DeleteClientService.class);
        var handler = new DeleteClientHandler(service);

        // act - assert
        assertDoesNotThrow(() -> handler.execute(1L));
    }
}