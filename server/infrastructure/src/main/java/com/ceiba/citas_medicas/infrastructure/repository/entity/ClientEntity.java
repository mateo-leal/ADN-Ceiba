package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * A {@link PersonaEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAS")
public class PersonaEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private String numeroDocumento;
    @Column private String nombres;
}