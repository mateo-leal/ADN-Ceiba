package com.ceiba.citas_medicas.domain.persistence;

import com.ceiba.citas_medicas.domain.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentPersistence {

    Appointment save(Appointment appointment);

    void delete(Appointment appointment);

    List<Appointment> findAll();

    Optional<Appointment> find(Long id);
}
