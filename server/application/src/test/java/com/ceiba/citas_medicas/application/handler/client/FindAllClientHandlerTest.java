package com.ceiba.citas_medicas.application.handler.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.service.client.FindAllClientService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAllClientHandlerTest {

    @Test
    void execute() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var service = mock(FindAllClientService.class);
        doReturn(List.of(client)).when(service).execute();
        var handler = new FindAllClientHandler(service);

        // act - assert
        assertThat(handler.execute()).isNotEmpty();
    }
}