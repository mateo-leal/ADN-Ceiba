package com.ceiba.citas_medicas.application.use_case;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.application.factory.CitaFactory;
import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.service.CrearCitaService;
import org.springframework.stereotype.Component;

@Component
public class CrearCitaUseCase {

    private final CrearCitaService service;
    private final CitaFactory factory;

    public CrearCitaUseCase(CrearCitaService service, CitaFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public Cita execute(CitaCommand citaCommand) {
        var cita = factory.build(citaCommand);
        return this.service.execute(cita);
    }
}
