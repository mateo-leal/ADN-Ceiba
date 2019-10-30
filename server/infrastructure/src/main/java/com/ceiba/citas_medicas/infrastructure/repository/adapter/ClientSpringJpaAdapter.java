package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.ClientPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.PersonaRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.PersonaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientSpringJpaAdapter implements ClientPersistence {

    private final PersonaRepository repository;

    @Autowired
    public ClientSpringJpaAdapter(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        var entity = PersonaFactory.toEntity(client);
        return PersonaFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Client client) {
        var entity = PersonaFactory.toEntity(client);
        repository.delete(entity);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll().stream()
                .map(PersonaFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> find(Long id) {
        return repository.findById(id)
                .map(PersonaFactory::toModel);
    }
}
