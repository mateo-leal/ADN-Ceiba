package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A {@link AppointmentEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APPOINTMENT")
public class AppointmentEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private LocalDateTime createdAt;
    @Column private LocalDateTime appointmentDate;
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) private ClientEntity client;
}
