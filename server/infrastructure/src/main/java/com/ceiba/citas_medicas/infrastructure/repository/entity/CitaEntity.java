package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A {@link CitaEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Table(name = "CITA")
public class CitaEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private LocalDateTime fechaSolicitud;
    @Column private LocalDateTime fechaCita;
    @ManyToOne private PersonaEntity persona;
}
