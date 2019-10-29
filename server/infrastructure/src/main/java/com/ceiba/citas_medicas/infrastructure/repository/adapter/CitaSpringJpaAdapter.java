package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.persistence.CitaPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.CitaRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.CitaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CitaSpringJpaAdapter implements CitaPersistence {

    private final CitaRepository repository;

    @Autowired
    public CitaSpringJpaAdapter(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cita save(Cita cita) {
        var entity = CitaFactory.toEntity(cita);
        return CitaFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Cita cita) {
        var entity = CitaFactory.toEntity(cita);
        repository.delete(entity);
    }

    @Override
    public List<Cita> findAll() {
        return repository.findAll().stream()
                .map(CitaFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cita> find(Long id) {
        return repository.findById(id)
                .map(CitaFactory::toModel);
    }
}
