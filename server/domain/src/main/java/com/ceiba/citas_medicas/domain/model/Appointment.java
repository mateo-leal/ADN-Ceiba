package com.ceiba.citas_medicas.domain.model;

import java.time.LocalDateTime;

import static com.ceiba.citas_medicas.domain.util.Message.getMessage;
import static com.ceiba.citas_medicas.domain.validation.Validators.*;
import static java.util.Objects.requireNonNull;

/**
 * A {@link Appointment} domain object.
 * @author Mateo Leal
 */
public class Appointment {

    private static final double APPOINTMENT_PRICE = 20000;

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime appointmentDate;
    private double price;
    private Client client;

    public Appointment(LocalDateTime appointmentDate, Client client) {
        this(LocalDateTime.now(), appointmentDate, client);
    }

    public Appointment(LocalDateTime createdAt, LocalDateTime appointmentDate, Client client) {
        this(null, createdAt, appointmentDate, client);
    }

    public Appointment(Long id, LocalDateTime createdAt, LocalDateTime appointmentDate, Client client) {
        this.id = id;
        setCreatedAt(createdAt);
        setAppointmentDate(appointmentDate);
        setClient(client);
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = requireNonNull(createdAt, getMessage("obligatorio.fecha_creacion"));
        requireNotWeekend(createdAt, getMessage("obligatorio.fecha_creacion_fin_semana"));
    }
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = requireNonNull(appointmentDate, getMessage("obligatorio.fecha_cita"));
        requireDifferentDay(appointmentDate, createdAt, getMessage("obligatorio.fecha_creacion_igual_cita"));
        requireDateGreater(createdAt, appointmentDate, getMessage("obligatorio.fecha_cita_mayor_creacion"));
        this.price = isWeekend(appointmentDate) ? (APPOINTMENT_PRICE * 2) : APPOINTMENT_PRICE;
    }
    public double getPrice() {
        return price;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = requireNonNull(client);
    }
}
