package com.ceiba.citas_medicas.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaCommand {
    private Long id;
    private String numeroDocumento;
    private String nombres;
}
