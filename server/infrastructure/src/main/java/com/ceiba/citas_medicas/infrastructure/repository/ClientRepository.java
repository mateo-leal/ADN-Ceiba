package com.ceiba.citas_medicas.infrastructure.repository;

import com.ceiba.citas_medicas.infrastructure.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<ClientEntity, Long> { }
