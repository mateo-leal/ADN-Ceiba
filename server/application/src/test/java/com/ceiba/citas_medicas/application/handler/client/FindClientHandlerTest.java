package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.client.FindClientService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindClientHandlerTest {

    @Test
    void execute() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var service = mock(FindClientService.class);
        doReturn(Optional.of(client)).when(service).execute(anyString());
        var handler = new FindClientHandler(service);

        // act - assert
        assertThat(handler.execute("")).isPresent();
    }
}