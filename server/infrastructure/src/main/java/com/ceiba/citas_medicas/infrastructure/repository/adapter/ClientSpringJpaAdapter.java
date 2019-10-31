package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientSpringJpaAdapter implements ClientPersistence {

    private final ClientRepository repository;

    @Autowired
    public ClientSpringJpaAdapter(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        var entity = ClientFactory.toEntity(client);
        return ClientFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Client client) {
        var entity = ClientFactory.toEntity(client);
        repository.delete(entity);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll().stream()
                .map(ClientFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> find(Long id) {
        return repository.findById(id)
                .map(ClientFactory::toModel);
    }

    @Override
    public Optional<Client> findByDocumentNumber(String documentNumber) {
        return repository.findByDocumentNumber(documentNumber)
                .map(ClientFactory::toModel);
    }
}
