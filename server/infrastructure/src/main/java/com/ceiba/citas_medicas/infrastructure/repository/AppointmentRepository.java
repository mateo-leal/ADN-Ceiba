package com.ceiba.citas_medicas.infrastructure.repository;

import com.ceiba.citas_medicas.infrastructure.repository.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> { }
