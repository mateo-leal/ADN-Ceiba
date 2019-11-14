package com.ceiba.citas_medicas.domain.service.client;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class FindAllClientServiceTest {

    @Test
    void findAll_when_exists() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        var client = new Client(1L, "123", "John Doe");
        doReturn(List.of(client)).when(persistence).findAll();
        var service = new FindAllClientService(persistence);

        // act
        var results = service.execute();

        // assert
        assertThat(results).isNotEmpty();
    }

    @Test
    void findAll_when_not_exists() {
        // arrange
        var persistence = mock(ClientPersistence.class);
        doReturn(Collections.emptyList()).when(persistence).findAll();
        var service = new FindAllClientService(persistence);

        // act
        var results = service.execute();

        // assert
        assertThat(results).isEmpty();
    }
}