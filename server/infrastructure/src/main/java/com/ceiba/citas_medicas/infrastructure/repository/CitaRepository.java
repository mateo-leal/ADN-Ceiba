package com.ceiba.citas_medicas.infrastructure.repository;

import com.ceiba.citas_medicas.infrastructure.repository.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<CitaEntity, Long> { }
