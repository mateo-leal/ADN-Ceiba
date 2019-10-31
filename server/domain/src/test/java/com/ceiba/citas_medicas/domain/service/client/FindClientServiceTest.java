package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindClientServiceTest {

    @Test
    void find_when_exists() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        var client = new Client("123", "John Doe");
        doReturn(Optional.of(client)).when(persistence).findByDocumentNumber(anyLong());
        var service = new FindClientService(persistence);

        // act
        var optionalAppointment = service.execute(1L);

        // assert
        assertTrue(optionalAppointment::isPresent);
    }

    @Test
    void find_when_not_exists() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        doReturn(Optional.empty()).when(persistence).findByDocumentNumber(anyLong());
        var service = new FindClientService(persistence);

        // act
        var optionalAppointment = service.execute(1L);

        // assert
        assertFalse(optionalAppointment::isPresent);
    }
}