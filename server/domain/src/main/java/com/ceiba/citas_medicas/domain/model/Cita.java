package com.ceiba.citas_medicas.domain.model;

import java.time.LocalDateTime;

public class Cita {

    private int id;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaCita;
    private Persona persona;
}
