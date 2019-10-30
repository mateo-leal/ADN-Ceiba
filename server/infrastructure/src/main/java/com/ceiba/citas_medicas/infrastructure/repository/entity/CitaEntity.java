package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A {@link CitaEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CITAS")
public class CitaEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private LocalDateTime fechaSolicitud;
    @Column private LocalDateTime fechaCita;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) private PersonaEntity persona;
}
