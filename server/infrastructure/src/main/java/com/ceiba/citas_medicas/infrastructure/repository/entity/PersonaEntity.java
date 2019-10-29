package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * A {@link PersonaEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Table(name = "PERSONA")
public class PersonaEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private String numeroDocumento;
    @Column private String nombres;
}