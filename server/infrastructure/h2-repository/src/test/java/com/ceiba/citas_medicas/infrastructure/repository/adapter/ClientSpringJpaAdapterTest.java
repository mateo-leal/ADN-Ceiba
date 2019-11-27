package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ClientSpringJpaAdapterTest {

    @Mock private ClientRepository repository;

    private final ClientEntity clientEntity = new ClientEntity(1L, "1234567890", "John Doe");
    private final Client client = new Client(1L, "1234567890", "John Doe");

    @Test
    void save() {
        // arrange
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        doReturn(clientEntity).when(repository).save(any(ClientEntity.class));
        // act
        var response = clientSpringJpaAdapter.save(client);
        // assert
        assertThat(response).isNotNull();
    }

    @Test
    void delete() {
        // arrange
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        clientSpringJpaAdapter.delete(client);
    }

    @Test
    void findAll() {
        // arrange
        doReturn(List.of(clientEntity)).when(repository).findAll();
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var response = clientSpringJpaAdapter.findAll();
        // assert
        assertThat(response).isNotEmpty();
    }

    @Test
    void find() {
        doReturn(Optional.of(clientEntity)).when(repository).findById(anyLong());
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var response = clientSpringJpaAdapter.find(1L);
        // assert
        assertThat(response).isPresent();
    }

    @Test
    void findByDocumentNumber() {
        doReturn(Optional.of(clientEntity)).when(repository).findByDocumentNumber(anyString());
        var clientSpringJpaAdapter = new ClientSpringJpaAdapter(repository);
        // act
        var response = clientSpringJpaAdapter.findByDocumentNumber("1234567890");
        // assert
        assertThat(response).isPresent();
    }
}