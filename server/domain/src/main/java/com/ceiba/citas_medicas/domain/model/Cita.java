package com.ceiba.citas_medicas.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * A {@link Cita} domain object.
 * @author Mateo Leal
 */
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = "id")
public class Cita {

    @Id @GeneratedValue private Long id;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaCita;
    @OneToMany private Persona persona;

    Cita(LocalDateTime fechaSolicitud, LocalDateTime fechaCita, Persona persona) {
        this.fechaSolicitud = fechaSolicitud;
        this.fechaCita = fechaCita;
        this.persona = persona;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }
}
