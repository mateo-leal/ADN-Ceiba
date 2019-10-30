package com.ceiba.citas_medicas.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.citas_medicas.domain.util.Message.getMessage;
import static com.ceiba.citas_medicas.domain.validation.ArgumentUtils.*;
import static java.util.Objects.requireNonNull;

/**
 * A {@link Appointment} domain object.
 * @author Mateo Leal
 */
@Getter
@EqualsAndHashCode
public class Appointment {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime appointmentDate;
    private Client client;

    public Appointment(LocalDateTime appointmentDate, Client client) {
        this(LocalDateTime.now(), appointmentDate, client);
    }

    public Appointment(LocalDateTime createdAt, LocalDateTime appointmentDate, Client client) {
        this(null, createdAt, appointmentDate, client);
    }

    public Appointment(Long id, LocalDateTime createdAt, LocalDateTime appointmentDate, Client client) {
        this.id = id;
        this.createdAt = requireNonNull(createdAt, getMessage("obligatorio.fecha_creacion"));
        requireNotWeekend(createdAt, getMessage("obligatorio.fecha_creacion_fin_semana"));
        this.appointmentDate = requireNonNull(appointmentDate, getMessage("obligatorio.fecha_cita"));
        requireDifferentDay(appointmentDate, createdAt, getMessage("obligatorio.fecha_creacion_igual_cita"));
        requireDateGreater(createdAt, appointmentDate, getMessage("obligatorio.fecha_cita_mayor_creacion"));
        this.client = requireNonNull(client);
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
