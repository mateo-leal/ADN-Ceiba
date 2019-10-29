package com.ceiba.citas_medicas.domain.model;

import java.time.LocalDateTime;

/**
 * A {@link Cita} domain object.
 * @author Mateo Leal
 */
public class Cita {

    private Long id;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaCita;
    private Persona persona;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public LocalDateTime getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
