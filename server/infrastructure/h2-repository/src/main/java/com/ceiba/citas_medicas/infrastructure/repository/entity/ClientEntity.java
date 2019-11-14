package com.ceiba.citas_medicas.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * A {@link ClientEntity} domain object.
 * @author Mateo Leal
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENT")
public class ClientEntity {

    @Id @Column @GeneratedValue private Long id;
    @Column private String documentNumber;
    @Column private String fullName;
}