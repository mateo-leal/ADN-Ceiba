package com.ceiba.citas_medicas.infrastructure.repository;

import com.ceiba.citas_medicas.infrastructure.repository.entity.AppointmentEntity;
import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findByClient(ClientEntity clientEntity);

    List<AppointmentEntity> findByClient_Id(Long clientId);
}
