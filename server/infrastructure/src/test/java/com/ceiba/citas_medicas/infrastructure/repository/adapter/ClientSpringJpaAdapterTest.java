package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.ClientFactory;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ClientSpringJpaAdapterTest {

    @Test
    void save() {
        // arrange
        var client = new Client("123", "John Doe");
        var repository = mock(ClientRepository.class);
        doReturn(ClientFactory.toEntity(client)).when(repository).save(any(ClientEntity.class));
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var savedClient = clientSpringJpaAdapter.save(client);
        // assert
        assertEquals(client, savedClient);
    }

    @Test
    void delete() {
        // arrange
        var client = new Client("123", "John Doe");
        var repository = mock(ClientRepository.class);
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act - assert
        clientSpringJpaAdapter.delete(client);
    }

    @Test
    void findAll() {
        // arrange
        var client = new Client("123", "John Doe");
        var repository = mock(ClientRepository.class);
        doReturn(List.of(ClientFactory.toEntity(client))).when(repository).findAll();
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var clientList = clientSpringJpaAdapter.findAll();
        // assert
        assertFalse(clientList::isEmpty);
    }

    @Test
    void find() {
        // arrange
        var client = new Client("123", "John Doe");
        var repository = mock(ClientRepository.class);
        doReturn(Optional.of(ClientFactory.toEntity(client))).when(repository).findById(anyLong());
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var optionalClient = clientSpringJpaAdapter.find(1L);
        // assert
        assertTrue(optionalClient::isPresent);
    }

    @Test
    void findByDocumentNumber() {
        // arrange
        var client = new Client("123", "John Doe");
        var repository = mock(ClientRepository.class);
        doReturn(Optional.of(ClientFactory.toEntity(client))).when(repository).findByDocumentNumber(anyString());
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var optionalClient = clientSpringJpaAdapter.findByDocumentNumber("");
        // assert
        assertTrue(optionalClient::isPresent);
    }
}