package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.exception.EntityExistsException;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateClientServiceTest {

    @Test
    void create_when_not_exists() {
        // arrange
        var client = new Client("123", "John Doe");
        var persistence = mock(ClientPersistence.class);
        doAnswer(invocation -> {
            // assert
            var clientArg = (Client) invocation.getArgument(0);
            assertThat(clientArg).isNotNull();
            assertThat(clientArg.getId()).isNull();
            return null;
        }).when(persistence).save(any(Client.class));
        var service = new CreateClientService(persistence);

        // act - assert
        assertThatCode(() -> service.execute(client)).doesNotThrowAnyException();
    }

    @Test
    void create_when_exists() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var persistence = mock(ClientPersistence.class);
        doAnswer(invocation -> {
            // assert
            var clientArg = (Client) invocation.getArgument(0);
            assertThat(clientArg).isNotNull();
            return null;
        }).when(persistence).save(any(Client.class));
        doReturn(Optional.of(client)).when(persistence).findByDocumentNumber(anyString());
        var service = new CreateClientService(persistence);

        // act - assert
        assertThatThrownBy(() -> service.execute(client))
                .isInstanceOf(EntityExistsException.class);
    }
}