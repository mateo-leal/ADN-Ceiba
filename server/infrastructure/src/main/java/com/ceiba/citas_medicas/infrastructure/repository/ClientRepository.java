package com.ceiba.citas_medicas.infrastructure.repository;

import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByDocumentNumber(String documentNumber);
}
