package com.ceiba.citas_medicas.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A {@link Persona} domain object.
 * @author Mateo Leal
 */
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = "id")
public class Persona {

    @Id @GeneratedValue private Long id;
    private String numeroDocumento;
    private String nombres;

    Persona() {
        this.numeroDocumento = null;
        this.nombres = null;
    }
}