package com.ceiba.citas_medicas.application.use_case.api;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.domain.model.Cita;

public interface CrearCitaUseCase {

    Cita execute(CitaCommand citaCommand);
}
