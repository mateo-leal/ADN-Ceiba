package com.ceiba.citas_medicas.infrastructure.repository.adapter;

import com.ceiba.citas_medicas.domain.model.Appointment;
import com.ceiba.citas_medicas.domain.model.Client;
import com.ceiba.citas_medicas.domain.persistence.AppointmentPersistence;
import com.ceiba.citas_medicas.infrastructure.repository.AppointmentRepository;
import com.ceiba.citas_medicas.infrastructure.repository.ClientRepository;
import com.ceiba.citas_medicas.infrastructure.repository.entity.factory.AppointmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentSpringJpaAdapter implements AppointmentPersistence {

    private final AppointmentRepository repository;
    private final ClientRepository clientRepository;

    @Autowired
    public AppointmentSpringJpaAdapter(AppointmentRepository repository,
                                       ClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        var entity = AppointmentFactory.toEntity(appointment);
        clientRepository.findById(appointment.getClient().getId())
                .ifPresent(entity::setClient);
        return AppointmentFactory.toModel(repository.save(entity));
    }

    @Override
    public void delete(Appointment appointment) {
        var entity = AppointmentFactory.toEntity(appointment);
        repository.delete(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return repository.findAll().stream()
                .map(AppointmentFactory::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointment> find(Long id) {
        return repository.findById(id)
                .map(AppointmentFactory::toModel);
    }

    public List<Appointment> findByClient(Client client) {
//        return clientRepository.findByDocumentNumber(client.getDocumentNumber())
//                .map(repository::findByClient)
//                .map(List::stream)
//                .map(appointmentEntityStream -> appointmentEntityStream.map(AppointmentFactory::toModel))
//                .map(appointmentStream -> appointmentStream.collect(Collectors.toList()))
//                .orElseGet(Collections::emptyList);
        return clientRepository.findByDocumentNumber(client.getDocumentNumber())
                .map(repository::findByClient)
                .orElseGet(Collections::emptyList).stream()
                .map(AppointmentFactory::toModel)
                .collect(Collectors.toList());
    }
}
