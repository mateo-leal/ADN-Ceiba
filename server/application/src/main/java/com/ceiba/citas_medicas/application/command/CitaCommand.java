package com.ceiba.citas_medicas.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CitaCommand {
    private Long id;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaCita;
    private PersonaCommand persona;
}
