package com.ceiba.citas_medicas.application.use_case.adapter;

import com.ceiba.citas_medicas.application.command.CitaCommand;
import com.ceiba.citas_medicas.application.factory.CitaFactory;
import com.ceiba.citas_medicas.application.use_case.api.CrearCitaUseCase;
import com.ceiba.citas_medicas.domain.model.Cita;
import com.ceiba.citas_medicas.domain.service.CrearCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrearCitaUseCaseAdapter implements CrearCitaUseCase {

    private final CrearCitaService service;
    private final CitaFactory factory;

    @Autowired
    public CrearCitaUseCaseAdapter(CrearCitaService service, CitaFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    public Cita execute(CitaCommand citaCommand) {
        var cita = factory.build(citaCommand);
        return this.service.execute(cita);
    }
}
