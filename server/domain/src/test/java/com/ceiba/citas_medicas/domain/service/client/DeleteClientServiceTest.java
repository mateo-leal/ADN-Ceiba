package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.exception.EntityNotExistsException;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class DeleteClientServiceTest {

    @Test
    void delete_when_exists() {
        // arrange
        var client = new Client(1L, "123", "John Doe");
        var persistence = mock(ClientPersistence.class);
        doReturn(Optional.of(client)).when(persistence).find(anyLong());
        var service = new DeleteClientService(persistence);

        // act - assert
        assertDoesNotThrow(() -> service.execute(1L));
    }

    @Test
    void delete_when_not_exists() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        doReturn(Optional.empty()).when(persistence).find(anyLong());
        var service = new DeleteClientService(persistence);

        // act - assert
        assertThrows(EntityNotExistsException.class, () -> service.execute(1L));
    }
}