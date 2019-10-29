package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.CitaRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.CitaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentSpringJpaAdapter implements AppointmentPersistence {

    private final CitaRepository repository;

    @Autowired
    public AppointmentSpringJpaAdapter(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        var entity = CitaFactory.toEntity(appointment);
        return CitaFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Appointment appointment) {
        var entity = CitaFactory.toEntity(appointment);
        repository.delete(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return repository.findAll().stream()
                .map(CitaFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointment> find(Long id) {
        return repository.findById(id)
                .map(CitaFactory::toModel);
    }
}
