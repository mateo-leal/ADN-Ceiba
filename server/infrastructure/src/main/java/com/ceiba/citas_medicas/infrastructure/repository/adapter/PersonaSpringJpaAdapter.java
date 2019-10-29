package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Persona;
import com.ceiba.citas_medicas.domain.persistence.PersonaPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.PersonaRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.PersonaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonaSpringJpaAdapter implements PersonaPersistence {

    private final PersonaRepository repository;

    @Autowired
    public PersonaSpringJpaAdapter(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Persona save(Persona Persona) {
        var entity = PersonaFactory.toEntity(Persona);
        return PersonaFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Persona Persona) {
        var entity = PersonaFactory.toEntity(Persona);
        repository.delete(entity);
    }

    @Override
    public List<Persona> findAll() {
        return repository.findAll().stream()
                .map(PersonaFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Persona> find(Long id) {
        return repository.findById(id)
                .map(PersonaFactory::toModel);
    }
}
